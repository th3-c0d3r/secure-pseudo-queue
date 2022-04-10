package com.example.demo.controller;

import com.example.demo.dto.ApiResponse;
import com.example.demo.dto.EncryptDto;
import com.example.demo.service.ReceiverService;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/receive")
@Hidden
public class ReceiverController {

  @Autowired
  private ReceiverService receiverService;

  @PostMapping()
  public ResponseEntity<?> receiveObject(@RequestBody EncryptDto payload) throws SQLException, JsonProcessingException {
    receiverService.receive(payload);
    return ResponseEntity.ok().body(ApiResponse.builder().message("Success").build());
  }
}
