package org.msbotframework4j.builder.exception;

/**
 * @author Maksim Kanev
 */
public class BotInstantiationException extends RuntimeException {

  public BotInstantiationException() {
  }

  public BotInstantiationException(String message) {
    super(message);
  }

  public BotInstantiationException(String message, Throwable cause) {
    super(message, cause);
  }
}
