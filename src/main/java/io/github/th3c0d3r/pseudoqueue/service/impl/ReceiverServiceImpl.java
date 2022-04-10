package io.github.th3c0d3r.pseudoqueue.service.impl;

import io.github.th3c0d3r.pseudoqueue.dto.EncryptDto;
import io.github.th3c0d3r.pseudoqueue.entity.Message;
import io.github.th3c0d3r.pseudoqueue.repo.MessageRepo;
import io.github.th3c0d3r.pseudoqueue.service.ReceiverService;
import io.github.th3c0d3r.pseudoqueue.utils.EncryptDecryptUtils;
import java.sql.SQLException;
import java.util.Objects;
import javax.sql.rowset.serial.SerialClob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ReceiverServiceImpl implements ReceiverService {

  @Autowired
  private MessageRepo messageRepo;

  @Override
  public void receive(EncryptDto obj) throws SQLException {
    log.info("Received Object: {}", obj);
    String transactionalObjStr = EncryptDecryptUtils.decrypt(obj.getEncryptedData(), "secret");
    log.info("Decrypt: {}", transactionalObjStr);
    char[] jsonCharArray;
    if (Objects.nonNull(transactionalObjStr)) {
      jsonCharArray = transactionalObjStr.toCharArray();
    } else {
      jsonCharArray = new char[0];
    }
    Message m = Message.builder().message(new SerialClob(jsonCharArray)).build();
    messageRepo.save(m);
  }
}
