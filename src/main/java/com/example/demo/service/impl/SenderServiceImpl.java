package com.example.demo.service.impl;

import com.example.demo.dto.ApiResponse;
import com.example.demo.service.SenderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Slf4j
@Service
public class SenderServiceImpl implements SenderService {

  private final RestTemplate restTemplate = new RestTemplate();

  @Override
  public void send(Object obj) {
    HttpEntity<?> request = new HttpEntity<>(obj);
    restTemplate.exchange("http://localhost:8080/receive/",
      HttpMethod.POST, request, ApiResponse.class);
  }
}
