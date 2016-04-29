package org.msbotframework4j.logging;

/**
 * Logger interface. Should be implemented to properly handle logs.
 *
 * @author <a href="mailto:maksim.kanev@gmail.com">Maksim Kanev</a>
 */
public interface BotLogger {

  /**
   * Logs a message at the DEBUG level
   *
   * @param message the message String to be logged
   */
  void debug(String message);

  /**
   * Logs an exception (throwable) at the DEBUG level with an accompanying message.
   *
   * @param message   the message accompanying the exception
   * @param exception the exception (throwable) to log
   */
  void debug(String message, Throwable exception);

  /**
   * Logs a message at the INFO level
   *
   * @param message the message String to be logged
   */
  void info(String message);

  /**
   * Logs an exception (throwable) at the INFO level with an accompanying message.
   *
   * @param message   the message accompanying the exception
   * @param exception the exception (throwable) to log
   */
  void info(String message, Throwable exception);

  /**
   * Logs a message at the WARNING level
   *
   * @param message the message String to be logged
   */
  void warn(String message);

  /**
   * Logs an exception (throwable) at the WARNING level with an accompanying message.
   *
   * @param message   the message accompanying the exception
   * @param exception the exception (throwable) to log
   */
  void warn(String message, Throwable exception);

  /**
   * Logs a message at the ERROR level
   *
   * @param message the message String to be logged
   */
  void error(String message);

  /**
   * Logs an exception (throwable) at the ERROR level with an accompanying message.
   *
   * @param message   the message accompanying the exception
   * @param exception the exception (throwable) to log
   */
  void error(String message, Throwable exception);

  /**
   * Logs an exception with exact severity level with an accompanying message
   *
   * @param severity  severity level
   * @param message   the message accompanying the exception
   * @param exception the exception (throwable) to log
   */
  void log(BotLogSeverity severity, String message, Throwable exception);

  /**
   * Writes log entry to logging stream
   *
   * @param entry log entry
   */
  void log(BotLogEntry entry);

  /**
   * Might be used to compose complicated log records
   *
   * @return {@link BotLogEntryBuilder} instance
   */
  BotLogEntryBuilder composeLogMessage();
}
