package org.msbotframework4j.logging;

import org.apache.commons.lang3.StringUtils;

import java.util.Date;

/**
 * Class that represents Bot log entry
 *
 * @author <a href="mailto:maksim.kanev@gmail.com">Maksim Kanev</a>
 */
public final class BotLogEntry {

  /**
   * Logger event datetime
   */
  private Date timestamp;
  /**
   * Logger event level
   */
  private BotLogSeverity severity;
  /**
   * Message string to be logged
   */
  private String message;
  /**
   * Exception (throwable) to log
   */
  private Throwable exception;

  BotLogEntry() {

  }

  public BotLogEntry(BotLogSeverity severity, String message) {
    this(severity, message, null);
  }

  public BotLogEntry(BotLogSeverity severity, Throwable exception) {
    this(severity, null, exception);
  }

  public BotLogEntry(BotLogSeverity severity, String message, Throwable exception) {
    this(new Date(), severity, message, exception);
  }

  public BotLogEntry(Date timestamp, BotLogSeverity severity, String message, Throwable exception) {
    this.timestamp = (timestamp == null ? new Date() : timestamp);
    this.severity = severity;
    this.exception = exception;
    buildMessage(message);
  }

  /**
   * Determines the final structure of log entry message
   *
   * @param message provided message
   */
  void buildMessage(String message) {
    if (message == null && exception == null) {
      this.message = StringUtils.EMPTY;
    } else if (message == null) {
      this.message = exception.getLocalizedMessage();
    } else if (exception == null) {
      this.message = message;
    } else {
      this.message = message + " caused by " + exception.getClass().getCanonicalName() + " " + exception.getLocalizedMessage();
    }
  }

  public Date getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(Date timestamp) {
    this.timestamp = timestamp;
  }

  public BotLogSeverity getSeverity() {
    return severity;
  }

  public void setSeverity(BotLogSeverity severity) {
    this.severity = severity;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Throwable getException() {
    return exception;
  }

  public void setException(Throwable exception) {
    this.exception = exception;
  }
}
