package org.msbotframework4j.builder.bot;

import org.msbotframework4j.core.model.Message;
import org.msbotframework4j.logging.BotLogger;

/**
 * @author <a href="mailto:maksim.kanev@gmail.com">Maksim Kanev</a>
 */
public interface Bot {

  String PING_RESPONSE_TEXT = "Pong";
  String BOT_ADDED_TO_CONVERSATION_RESPONSE_TEXT = "Hello";
  String BOT_REMOVED_FROM_CONVERSATION_RESPONSE_TEXT = "Bye guys";
  String END_OF_CONVERSATION_RESPONSE_TEXT = BOT_REMOVED_FROM_CONVERSATION_RESPONSE_TEXT;
  String NOT_SUPPORTED_TYPE_RESPONSE_TEXT = "This message type is not supported yet. Please contact the bot creator.";

  Message getReply(Message message, BotLogger logger);
}
