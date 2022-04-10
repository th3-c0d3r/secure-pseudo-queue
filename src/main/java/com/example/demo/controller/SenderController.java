package com.example.demo.controller;

import com.example.demo.dto.ApiResponse;
import com.example.demo.service.SenderService;
import com.fasterxml.jackson.core.JsonProcessingException;
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
  public ResponseEntity<?> send(@RequestBody Object payload) throws JsonProcessingException {
    senderService.send(payload);
    return ResponseEntity.ok().body(ApiResponse.builder().message("Sent Successfully").build());
  }
}
