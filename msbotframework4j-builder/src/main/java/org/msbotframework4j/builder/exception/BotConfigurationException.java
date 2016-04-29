package org.msbotframework4j.builder.exception;

/**
 * @author Maksim Kanev
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
