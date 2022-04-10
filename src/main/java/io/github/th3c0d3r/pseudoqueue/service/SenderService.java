package io.github.th3c0d3r.pseudoqueue.service;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface SenderService {

  void send(Object obj) throws JsonProcessingException;
}
