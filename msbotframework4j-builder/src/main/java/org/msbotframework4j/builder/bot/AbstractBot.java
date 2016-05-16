package org.msbotframework4j.builder.bot;

import org.msbotframework4j.core.model.Message;
import org.msbotframework4j.logging.BotLogger;

/**
 * Base class for BotFramework compatible bots
 *
 * @author <a href="mailto:maksim.kanev@gmail.com">Maksim Kanev</a>
 */
public abstract class AbstractBot implements Bot {

  /**
   * Main method with logic to process messages
   *
   * @param message message to process
   * @param logger  {@link BotLogger} instance
   * @return reply message
   */
  @Override
  public final Message getReply(Message message, BotLogger logger) {
    beforeProcess(message, logger);
    Message replyMessage = processMessageByMessageType(message, logger);
    beforeSend(replyMessage, message, logger);
    return replyMessage;
  }

  /**
   * Method to pre-process input message
   *
   * @param request input message
   * @param logger  {@link BotLogger} instance
   */
  protected void beforeProcess(Message request, BotLogger logger) {

  }

  private Message processMessageByMessageType(Message request, BotLogger logger) {
    switch (request.getType()) {
      case MESSAGE:
        return onMessage(request, logger);
      case PING:
        return onPing(request, logger);
      case DELETE_USER_DATA:
        return onDeleteUserData(request, logger);
      case BOT_ADDED_TO_CONVERSATION:
        return onBotAddedToConversation(request, logger);
      case BOT_REMOVED_FROM_CONVERSATION:
        return onBotRemovedFromConversation(request, logger);
      case USER_ADDED_TO_CONVERSATION:
        return onUserAddedConversation(request, logger);
      case USER_REMOVED_FROM_CONVERSATION:
        return onUserRemovedFromConversation(request, logger);
      case END_OF_CONVERSATION:
        return onEndOfConversation(request, logger);
      default:
        return defaultResponse(request, logger);
    }
  }

  /**
   * (REQUIRED) Method to execute bot logic and compose a reply message
   *
   * @param request input message
   * @param logger  {@link BotLogger} instance
   * @return reply message
   */
  protected abstract Message onMessage(Message request, BotLogger logger);

  /**
   * Method to handle 'Ping' requests from Microsoft BotConnector Emulator
   *
   * @param request input message
   * @param logger  {@link BotLogger} instance
   * @return reply message
   */
  protected Message onPing(Message request, BotLogger logger) {
    return request.createReplyMessage("Pong");
  }

  /**
   * Method to handle {@link org.msbotframework4j.core.model.MessageType#DELETE_USER_DATA} event
   *
   * @param request input message
   * @param logger  {@link BotLogger} instance
   * @return reply message
   */
  protected Message onDeleteUserData(Message request, BotLogger logger) {
    return defaultResponse(request, logger);
  }

  /**
   * Method to handle {@link org.msbotframework4j.core.model.MessageType#BOT_ADDED_TO_CONVERSATION} event
   *
   * @param request input message
   * @param logger  {@link BotLogger} instance
   * @return reply message
   */

  protected Message onBotAddedToConversation(Message request, BotLogger logger) {
    return request.createReplyMessage("Hello!");
  }

  /**
   * Method to handle {@link org.msbotframework4j.core.model.MessageType#BOT_REMOVED_FROM_CONVERSATION} event
   *
   * @param request input message
   * @param logger  {@link BotLogger} instance
   * @return reply message
   */

  protected Message onBotRemovedFromConversation(Message request, BotLogger logger) {
    return request.createReplyMessage("Bye guys!");
  }

  /**
   * Method to handle {@link org.msbotframework4j.core.model.MessageType#USER_ADDED_TO_CONVERSATION} event
   *
   * @param request input message
   * @param logger  {@link BotLogger} instance
   * @return reply message
   */

  protected Message onUserAddedConversation(Message request, BotLogger logger) {
    return defaultResponse(request, logger);
  }

  /**
   * Method to handle {@link org.msbotframework4j.core.model.MessageType#USER_REMOVED_FROM_CONVERSATION} event
   *
   * @param request input message
   * @param logger  {@link BotLogger} instance
   * @return reply message
   */

  protected Message onUserRemovedFromConversation(Message request, BotLogger logger) {
    return defaultResponse(request, logger);
  }

  /**
   * Method to handle {@link org.msbotframework4j.core.model.MessageType#END_OF_CONVERSATION} event
   *
   * @param request input message
   * @param logger  {@link BotLogger} instance
   * @return reply message
   */

  protected Message onEndOfConversation(Message request, BotLogger logger) {
    return request.createReplyMessage("Bye guys!");
  }

  private Message defaultResponse(Message request, BotLogger logger) {
    logger.warn("Message type is not supported: " + request.getType());
    return request.createReplyMessage("This message type is not supported yet. Please contact the bot creator.");
  }

  /**
   * Method to post-process reply message
   *
   * @param response reply message
   * @param request  input message
   * @param logger   {@link BotLogger} instance
   */
  protected void beforeSend(Message response, Message request, BotLogger logger) {

  }
}
