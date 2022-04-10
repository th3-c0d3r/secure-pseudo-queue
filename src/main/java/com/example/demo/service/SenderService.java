package com.example.demo.service;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface SenderService {

  void send(Object obj) throws JsonProcessingException;
}
