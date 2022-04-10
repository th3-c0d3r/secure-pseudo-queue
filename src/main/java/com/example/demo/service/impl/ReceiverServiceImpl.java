package com.example.demo.service.impl;

import com.example.demo.entity.Message;
import com.example.demo.repo.MessageRepo;
import com.example.demo.service.ReceiverService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.sql.Clob;
import java.sql.SQLException;
import javax.sql.rowset.serial.SerialClob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ReceiverServiceImpl implements ReceiverService {

  @Autowired
  private MessageRepo messageRepo;

  private final ObjectMapper mapper = new ObjectMapper();

  @Override
  public void receive(Object obj) throws SQLException, JsonProcessingException {
    log.info("Received Object: {}", obj);
    char[] jsonCharArray = mapper.writeValueAsString(obj).toCharArray();
    Message m = Message.builder().message(new SerialClob(jsonCharArray)).build();
    messageRepo.save(m);
  }
}
