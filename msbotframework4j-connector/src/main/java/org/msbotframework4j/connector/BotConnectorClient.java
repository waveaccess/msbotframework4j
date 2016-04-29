package org.msbotframework4j.connector;

import org.msbotframework4j.core.model.BotData;
import org.msbotframework4j.core.model.Message;

import java.util.Optional;

/**
 * BotConnector client interfaces. Might be used to asynchronously communicate with users.
 *
 * @author <a href="mailto:maksim.kanev@gmail.com">Maksim Kanev</a>
 */
public interface BotConnectorClient {

  String API_ENDPOINT = "https://api.botframework.com";

  /**
   * Get the BotData record for the user
   *
   * @param botId  the BotId
   * @param userId the UserId
   */
  Optional<BotData> getUserData(String botId, String userId);

  /**
   * Update the bot user data
   *
   * @param botId  the BotId
   * @param userId the UserId
   * @param data   the new BotData
   */
  Optional<BotData> setUserData(String botId, String userId, BotData data);

  /**
   * Get the BotData record for the conversation
   *
   * @param botId          the BotId
   * @param conversationId the ConversationId
   */
  Optional<BotData> getConversationData(String botId, String conversationId);

  /**
   * Update the bot conversation data
   *
   * @param botId          the BotId
   * @param conversationId the ConversationId
   * @param data           the new BotData
   */
  Optional<BotData> setConversationData(String botId, String conversationId, BotData data);

  /**
   * Get the BotData record for the user in the conversation
   *
   * @param botId          the BotId
   * @param conversationId the ConversationId
   * @param userId         the UserId
   */
  Optional<BotData> getPerUserConversationData(String botId, String conversationId, String userId);

  /**
   * Update the bot user in a conversation data
   *
   * @param botId          the BotId
   * @param conversationId the ConversationId
   * @param userId         the UserId
   * @param data           the new BotData
   */
  Optional<BotData> setPerUserConversationData(String botId, String conversationId, String userId, BotData data);

  /**
   * Initiate a new conversation with the user. The important fields are From, To, Text and Language.
   *
   * @param message the message that will initiate a conversation
   * @return message object
   */
  Optional<Message> sendMessage(Message message);

}
