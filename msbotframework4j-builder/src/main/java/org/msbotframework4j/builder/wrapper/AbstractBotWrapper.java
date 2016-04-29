package org.msbotframework4j.builder.wrapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.msbotframework4j.builder.BotManager;
import org.msbotframework4j.builder.bot.Bot;
import org.msbotframework4j.core.model.Message;
import org.msbotframework4j.logging.BotLogger;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author Maksim Kanev
 */
public class AbstractBotWrapper {

  private static final ObjectMapper mapper = new ObjectMapper();
  private final Bot bot;

  AbstractBotWrapper() {
    this.bot = BotManager.getInstance().load();
  }

  Message readMessage(InputStream src) throws IOException {
    return mapper.readValue(src, Message.class);
  }

  Message getReply(Message request, BotLogger logger) {
    return bot.getReply(request, logger);
  }

  void writeMessage(OutputStream out, Message value) throws IOException {
    mapper.writeValue(out, value);
  }

  String writeMessageAsString(Message value) throws JsonProcessingException {
    return mapper.writeValueAsString(value);
  }
}
