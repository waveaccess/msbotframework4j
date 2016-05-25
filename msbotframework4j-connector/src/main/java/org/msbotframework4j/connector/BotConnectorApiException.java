package org.msbotframework4j.connector;

/**
 * @author <a href="mailto:maksim.kanev@gmail.com">Maksim Kanev</a>
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
