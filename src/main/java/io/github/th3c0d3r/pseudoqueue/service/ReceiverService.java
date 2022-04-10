package io.github.th3c0d3r.pseudoqueue.service;

import io.github.th3c0d3r.pseudoqueue.dto.EncryptDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.sql.SQLException;

public interface ReceiverService {

  void receive(EncryptDto obj) throws SQLException, JsonProcessingException;

}
