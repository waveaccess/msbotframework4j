package org.msbotframework4j.connector;

/**
 * @author Maksim Kanev
 */
public class BotConnectorApiException extends RuntimeException {

  public BotConnectorApiException() {
  }

  public BotConnectorApiException(String message) {
    super(message);
  }

  public BotConnectorApiException(String message, Throwable cause) {
    super(message, cause);
  }
}
