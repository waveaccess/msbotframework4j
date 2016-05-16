package org.msbotframework4j.connector;

import com.mashape.unirest.http.ObjectMapper;
import com.mashape.unirest.http.Unirest;

import org.msbotframework4j.core.json.SerializerFacade;
import org.msbotframework4j.logging.BotLogger;

/**
 * Factory class for BotConnector Clients
 *
 * @author <a href="mailto:maksim.kanev@gmail.com">Maksim Kanev</a>
 */
public class BotConnectorClientFactory {

  private final String API_VERSION_1_0 = "v1.0";

  private BotConnectorClientFactory() {
    Unirest.setObjectMapper(new ObjectMapper() {
      @Override
      public <T> T readValue(String s, Class<T> aClass) {
        return SerializerFacade.fromJsonString(aClass, s);
      }

      @Override
      public String writeValue(Object o) {
        return SerializerFacade.toJsonString(o.getClass(), o);
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
