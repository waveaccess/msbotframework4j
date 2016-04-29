package org.msbotframework4j.connector;

/**
 * @author Maksim Kanev
 */
abstract class AbstractBotConnectorClient implements BotConnectorClient {

  private final String apiVersion;
  final String appId;
  final String appSecret;

  AbstractBotConnectorClient(String apiVersion, String appId, String appSecret) {
    this.apiVersion = apiVersion;
    this.appId = appId;
    this.appSecret = appSecret;
  }

  String getUserDataApi() {
    return API_ENDPOINT + getUserDataApiPath();
  }

  private String getUserDataApiPath() {
    return getBotApiPathPrefix() + "/users/{userId}";
  }

  String getConversationDataApi() {
    return API_ENDPOINT + getConversationDataApiPath();
  }

  private String getConversationDataApiPath() {
    return getBotApiPathPrefix() + "/conversations/{conversationId}";
  }

  String getPerUserConversationDataApi() {
    return API_ENDPOINT + getPerUserConversationDataApiPath();
  }

  private String getPerUserConversationDataApiPath() {
    return getConversationDataApiPath() + "/users/{userId}";
  }

  private String getBotApiPathPrefix() {
    return getApiPathPrefix() + "/bots/{botId}";
  }

  String getMessagesApi() {
    return API_ENDPOINT + getMessagesApiPath();
  }

  private String getMessagesApiPath() {
    return getApiPathPrefix() + "/messages";
  }

  private String getApiPathPrefix() {
    return "/bot/" + apiVersion;
  }

}
