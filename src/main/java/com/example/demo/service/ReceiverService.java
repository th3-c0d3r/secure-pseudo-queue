package com.example.demo.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import java.sql.SQLException;

public interface ReceiverService {

  void receive(Object obj) throws SQLException, JsonProcessingException;

}
