package org.msbotframework4j.builder.wrapper;

import com.google.common.io.CharStreams;

import org.msbotframework4j.builder.BotManager;
import org.msbotframework4j.builder.bot.Bot;
import org.msbotframework4j.core.json.SerializerFacade;
import org.msbotframework4j.core.model.Message;
import org.msbotframework4j.logging.BotLogger;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

/**
 * @author Maksim Kanev
 */
public class AbstractBotWrapper {

  private final Bot bot;

  AbstractBotWrapper() {
    this.bot = BotManager.getInstance().load();
  }

  Message readMessage(InputStream src, BotLogger logger) throws IOException {
    String input = CharStreams.toString(new InputStreamReader(src, StandardCharsets.UTF_8));
    logger.debug("Received JSON: " + input);
    return SerializerFacade.fromJsonString(Message.class, input);
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
