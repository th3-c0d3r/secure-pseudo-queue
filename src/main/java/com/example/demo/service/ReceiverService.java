package com.example.demo.service;

import com.example.demo.dto.EncryptDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.sql.SQLException;

public interface ReceiverService {

  void receive(EncryptDto obj) throws SQLException, JsonProcessingException;

}
