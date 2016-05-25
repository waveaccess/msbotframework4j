package org.msbotframework4j.builder.exception;

/**
 * @author <a href="mailto:maksim.kanev@gmail.com">Maksim Kanev</a>
 */
public class BotConfigurationException extends RuntimeException {

  public BotConfigurationException() {
  }

  public BotConfigurationException(String message) {
    super(message);
  }

  public BotConfigurationException(String message, Throwable cause) {
    super(message, cause);
  }
}
