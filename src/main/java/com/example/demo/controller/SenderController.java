package com.example.demo.controller;

import com.example.demo.dto.ApiResponse;
import com.example.demo.service.SenderService;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/send")
public class SenderController {

  @Autowired
  private SenderService senderService;

  @PostMapping
  @Operation(summary = "Api receives data to be pused into fake queue. " +
    "Successfully pushed message will be stored in DB, which can be viewed in baseUrl/h2-console")
  public ResponseEntity<?> send(@RequestBody Object payload) throws JsonProcessingException {
    senderService.send(payload);
    return ResponseEntity.ok().body(ApiResponse.builder().message("Sent Successfully").build());
  }
}
