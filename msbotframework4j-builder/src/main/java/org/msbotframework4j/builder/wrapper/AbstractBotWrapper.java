package org.msbotframework4j.builder.wrapper;

import org.msbotframework4j.builder.BotManager;
import org.msbotframework4j.builder.bot.Bot;
import org.msbotframework4j.core.json.SerializerFacade;
import org.msbotframework4j.core.model.Message;
import org.msbotframework4j.logging.BotLogger;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author Maksim Kanev
 */
public class AbstractBotWrapper {

  private final Bot bot;

  AbstractBotWrapper() {
    this.bot = BotManager.getInstance().load();
  }

  Message readMessage(InputStream src) throws IOException {
    return SerializerFacade.fromJson(src, Message.class);
  }

  Message getReply(Message request, BotLogger logger) {
    return bot.getReply(request, logger);
  }

  void writeMessage(OutputStream out, Message value) throws IOException {
    SerializerFacade.toJson(out, Message.class, value);
  }

  String writeMessageAsString(Message value) {
    return SerializerFacade.toJsonString(Message.class, value);
  }
}
