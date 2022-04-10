package com.example.demo.service.impl;

import com.example.demo.dto.ApiResponse;
import com.example.demo.dto.EncryptDto;
import com.example.demo.service.SenderService;
import com.example.demo.utils.EncryptDecryptUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Slf4j
@Service
public class SenderServiceImpl implements SenderService {

  private final RestTemplate restTemplate = new RestTemplate();
  private final ObjectMapper mapper = new ObjectMapper();

  @Value("${app.base.url}")
  private String baseUrl;

  @Override
  public void send(Object obj) throws JsonProcessingException {
    log.info("Object to send: {}", obj);
    String transactionalObjStr = EncryptDecryptUtils.encrypt(mapper.writeValueAsString(obj), "secret");
    log.info("Encrypt: {}", transactionalObjStr);

    // Instead of making rest call, receive() in ReceiveService can be called directly
    HttpEntity<?> request = new HttpEntity<>(EncryptDto.builder().encryptedData(transactionalObjStr).build());
    restTemplate.exchange(baseUrl + "/receive/",
      HttpMethod.POST, request, ApiResponse.class);
  }
}
