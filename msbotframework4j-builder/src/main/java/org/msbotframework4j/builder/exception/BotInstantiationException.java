package org.msbotframework4j.builder.exception;

/**
 * @author <a href="mailto:maksim.kanev@gmail.com">Maksim Kanev</a>
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
