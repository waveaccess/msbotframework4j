package org.msbotframework4j.connector;

import com.mashape.unirest.http.ObjectMapper;
import com.mashape.unirest.http.Unirest;

import org.msbotframework4j.logging.BotLogger;

import java.io.IOException;

/**
 * Factory class for BotConnector Clients
 *
 * @author <a href="mailto:maksim.kanev@gmail.com">Maksim Kanev</a>
 */
public class BotConnectorClientFactory {

  private final String API_VERSION_1_0 = "v1.0";

  private BotConnectorClientFactory() {
    Unirest.setObjectMapper(new ObjectMapper() {
      private final com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();

      @Override
      public <T> T readValue(String s, Class<T> aClass) {
        try {
          return mapper.readValue(s, aClass);
        } catch (IOException e) {
          throw new RuntimeException(e);
        }
      }

      @Override
      public String writeValue(Object o) {
        try {
          return mapper.writeValueAsString(o);
        } catch (IOException e) {
          throw new RuntimeException(e);
        }
      }
    });
  }

  /**
   * Returns an instance of asynchronous client for BotConnector REST API v1.0
   *
   * @param logger    {@link BotLogger} instance
   * @param appId     bot's appId
   * @param appSecret bot's appSecret
   * @return {@link BotConnectorClientAsync} instance
   */
  public BotConnectorClient getAsyncClientV1(BotLogger logger, String appId, String appSecret) {
    return new BotConnectorClientAsync(logger, API_VERSION_1_0, appId, appSecret);
  }

  /**
   * Returns singleton instance of {@link BotConnectorClientFactory}
   *
   * @return {@link BotConnectorClientFactory} instance
   */
  public static BotConnectorClientFactory getInstance() {
    return BotConnectorClientFactoryInstanceHolder.INSTANCE;
  }

  private static class BotConnectorClientFactoryInstanceHolder {

    static final BotConnectorClientFactory INSTANCE = new BotConnectorClientFactory();
  }

}
