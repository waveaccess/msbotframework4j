package org.msbotframework4j.builder.exception;

/**
 * @author <a href="mailto:maksim.kanev@gmail.com">Maksim Kanev</a>
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
