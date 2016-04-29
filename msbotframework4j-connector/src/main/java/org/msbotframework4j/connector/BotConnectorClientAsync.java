package org.msbotframework4j.connector;

import com.google.common.base.Optional;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.request.GetRequest;
import com.mashape.unirest.request.HttpRequestWithBody;

import org.apache.http.HttpHeaders;
import org.apache.http.HttpStatus;
import org.apache.http.entity.ContentType;
import org.msbotframework4j.core.common.Const;
import org.msbotframework4j.core.model.BotData;
import org.msbotframework4j.core.model.Error;
import org.msbotframework4j.core.model.GenericApiEntity;
import org.msbotframework4j.core.model.Message;
import org.msbotframework4j.logging.BotLogSeverity;
import org.msbotframework4j.logging.BotLogger;

/**
 * {@link BotConnectorClient} implementation for asynchronous communications with BotConnector API
 *
 * @author <a href="mailto:maksim.kanev@gmail.com">Maksim Kanev</a>
 */
class BotConnectorClientAsync extends AbstractBotConnectorClient implements BotConnectorClient {

  private final BotLogger logger;

  BotConnectorClientAsync(BotLogger logger, String apiVersion, String appId, String appSecret) {
    super(apiVersion, appId, appSecret);
    this.logger = logger;
  }

  @Override
  public Optional<BotData> getUserData(String botId, String userId) {
    try {
      logger.composeLogMessage()
          .append("Attempt to get BotData record for the user")
          .appendWhitespaceSeparator().append("botId=%s", botId)
          .appendWhitespaceSeparator().append("userId=%s", userId)
          .withSeverity(BotLogSeverity.DEBUG)
          .push();
      HttpResponse<BotData> response = get(getUserDataApi())
          .routeParam("botId", botId)
          .routeParam("userId", userId)
          .asObject(BotData.class);
      validateResponseStatus(response);
      return Optional.of(response.getBody());
    } catch (Exception ex) {
      logger.error("Couldn't get BotData record for the user", ex);
      return Optional.absent();
    }
  }

  @Override
  public Optional<BotData> setUserData(String botId, String userId, BotData data) {
    try {
      logger.composeLogMessage()
          .append("Attempt to update the bot user data")
          .appendWhitespaceSeparator().append("botId=%s", botId)
          .appendWhitespaceSeparator().append("userId=%s", userId)
          .appendWhitespaceSeparator().append("BotData=%s", data.toString())
          .withSeverity(BotLogSeverity.DEBUG)
          .push();
      HttpResponse<BotData> response = post(getUserDataApi())
          .routeParam("botId", botId)
          .routeParam("userId", userId)
          .body(data)
          .asObject(BotData.class);
      validateResponseStatus(response);
      return Optional.of(response.getBody());
    } catch (Exception ex) {
      logger.error("Couldn't update the bot user data", ex);
      return Optional.absent();
    }
  }

  @Override
  public Optional<BotData> getConversationData(String botId, String conversationId) {
    try {
      logger.composeLogMessage()
          .append("Attempt to get the BotData record for the conversation")
          .appendWhitespaceSeparator().append("botId=%s", botId)
          .appendWhitespaceSeparator().append("conversationId=%s", conversationId)
          .withSeverity(BotLogSeverity.DEBUG)
          .push();
      HttpResponse<BotData> response = get(getConversationDataApi())
          .routeParam("botId", botId)
          .routeParam("conversationId", conversationId)
          .asObject(BotData.class);
      validateResponseStatus(response);
      return Optional.of(response.getBody());
    } catch (Exception ex) {
      logger.error("Couldn't get the BotData record for the conversation", ex);
      return Optional.absent();
    }
  }

  @Override
  public Optional<BotData> setConversationData(String botId, String conversationId, BotData data) {
    try {
      logger.composeLogMessage()
          .append("Attempt to update the bot conversation data")
          .appendWhitespaceSeparator().append("botId=%s", botId)
          .appendWhitespaceSeparator().append("conversationId=%s", conversationId)
          .appendWhitespaceSeparator().append("BotData=%s", data.toString())
          .withSeverity(BotLogSeverity.DEBUG)
          .push();
      HttpResponse<BotData> response = post(getConversationDataApi())
          .routeParam("botId", botId)
          .routeParam("conversationId", conversationId)
          .body(data)
          .asObject(BotData.class);
      validateResponseStatus(response);
      return Optional.of(response.getBody());
    } catch (Exception ex) {
      logger.error("Couldn't update the bot conversation data", ex);
      return Optional.absent();
    }
  }

  @Override
  public Optional<BotData> getPerUserConversationData(String botId, String conversationId, String userId) {
    try {
      logger.composeLogMessage()
          .append("Attempt to get the BotData record for the user in the conversation")
          .appendWhitespaceSeparator().append("botId=%s", botId)
          .appendWhitespaceSeparator().append("conversationId=%s", conversationId)
          .appendWhitespaceSeparator().append("userId=%s", userId)
          .withSeverity(BotLogSeverity.DEBUG)
          .push();
      HttpResponse<BotData> response = get(getPerUserConversationDataApi())
          .routeParam("botId", botId)
          .routeParam("conversationId", conversationId)
          .routeParam("userId", userId)
          .asObject(BotData.class);
      validateResponseStatus(response);
      return Optional.of(response.getBody());
    } catch (Exception ex) {
      logger.error("Couldn't get the BotData record for the user in the conversation", ex);
      return Optional.absent();
    }
  }

  @Override
  public Optional<BotData> setPerUserConversationData(String botId, String conversationId, String userId, BotData data) {
    try {
      logger.composeLogMessage()
          .append("Attempt to update the bot user in a conversation data")
          .appendWhitespaceSeparator().append("botId=%s", botId)
          .appendWhitespaceSeparator().append("conversationId=%s", conversationId)
          .appendWhitespaceSeparator().append("userId=%s", userId)
          .appendWhitespaceSeparator().append("BotData=%s", data.toString())
          .withSeverity(BotLogSeverity.DEBUG)
          .push();
      HttpResponse<BotData> response = post(getPerUserConversationDataApi())
          .routeParam("botId", botId)
          .routeParam("conversationId", conversationId)
          .routeParam("userId", userId)
          .body(data)
          .asObject(BotData.class);
      validateResponseStatus(response);
      return Optional.of(response.getBody());
    } catch (Exception ex) {
      logger.error("Couldn't update the bot user in a conversation data", ex);
      return Optional.absent();
    }
  }

  @Override
  public Optional<Message> sendMessage(Message message) {
    try {
      logger.debug("Attempt to send message: " + message.toString());
      HttpResponse<Message> response = post(getMessagesApi())
          .body(message)
          .asObject(Message.class);
      validateResponseStatus(response);
      return Optional.of(response.getBody());
    } catch (Exception ex) {
      logger.error("Couldn't communicate with BotConnector", ex);
      return Optional.absent();
    }
  }

  /**
   * Compose POST request to BotConnector API. Sets Basic Authorization, BotConnector Auth, Accept and Content-Type headers.
   *
   * @param endpointUrl BotConnector API endpoint URL
   * @return {@link HttpRequestWithBody} object
   */
  private HttpRequestWithBody post(String endpointUrl) {
    return Unirest.post(endpointUrl)
        .basicAuth(this.appId, this.appSecret)
        .header(Const.REST_AUTH_HEADER, appSecret)
        .header(HttpHeaders.ACCEPT, ContentType.APPLICATION_JSON.getMimeType())
        .header(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.getMimeType());
  }

  /**
   * Compose GET request to BotConnector API. Sets Basic Authorization and BotConnector Auth headers.
   *
   * @param endpointUrl BotConnector API endpoint URL
   * @return {@link GetRequest} object
   */
  private GetRequest get(String endpointUrl) {
    return Unirest.get(endpointUrl)
        .basicAuth(this.appId, this.appSecret)
        .header(Const.REST_AUTH_HEADER, appSecret);
  }

  /**
   * Validate BotConnector API HTTP response status
   *
   * @param response BotConnector API HTTP response
   */
  private void validateResponseStatus(HttpResponse<? extends GenericApiEntity> response) {
    GenericApiEntity entity = response.getBody();
    int responseHttpStatus = response.getStatus();
    Error error = entity.getError();
    if (HttpStatus.SC_OK == responseHttpStatus) {
      // all is good - leave
      return;
    }
    logger.error(error.toString());
    switch (responseHttpStatus) {
      case HttpStatus.SC_BAD_REQUEST:
      case HttpStatus.SC_NOT_FOUND:
      case HttpStatus.SC_INTERNAL_SERVER_ERROR:
        throw new BotConnectorApiException(error.getMessage());
      case HttpStatus.SC_UNAUTHORIZED:
        throw new BotConnectorApiException("Authentication failed. Check HTTP request headers.");
      case HttpStatus.SC_FORBIDDEN:
        throw new BotConnectorApiException("You are forbidden from performing this action. Possible reasons: your credentials don't allow you to or your account has exceeded a quota");
      case HttpStatus.SC_SERVICE_UNAVAILABLE:
        throw new BotConnectorApiException("The service you are trying to communicate with was unavailable");
      default:
        throw new IllegalArgumentException("Unknown API HTTP response status: " + responseHttpStatus + " Error: " + error.toString());
    }
  }
}
