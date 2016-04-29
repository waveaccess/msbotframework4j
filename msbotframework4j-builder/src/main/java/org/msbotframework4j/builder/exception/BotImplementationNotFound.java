package org.msbotframework4j.builder.exception;

/**
 * @author Maksim Kanev
 */
public class BotImplementationNotFound extends RuntimeException {

  public BotImplementationNotFound() {
  }

  public BotImplementationNotFound(String message) {
    super(message);
  }

  public BotImplementationNotFound(String message, Throwable cause) {
    super(message, cause);
  }
}
