package org.msbotframework4j.logging;

import org.apache.commons.lang3.text.StrBuilder;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Base class for adapters for bot logging system
 *
 * @author <a href="mailto:maksim.kanev@gmail.com">Maksim Kanev</a>
 */
public abstract class AbstractBotLogger implements BotLogger {

  /**
   * Date would be formatted like Wed, 4 Jul 2001 12:08:56 -0700
   */
  private static final DateFormat DATE_FORMAT = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z");

  @Override
  public void debug(String message) {
    log(BotLogSeverity.DEBUG, message, null);
  }

  @Override
  public void debug(String message, Throwable exception) {
    log(BotLogSeverity.DEBUG, message, exception);
  }

  @Override
  public void info(String message) {
    log(BotLogSeverity.INFO, message, null);
  }

  @Override
  public void info(String message, Throwable exception) {
    log(BotLogSeverity.INFO, message, exception);
  }

  @Override
  public void warn(String message) {
    log(BotLogSeverity.WARNING, message, null);
  }

  @Override
  public void warn(String message, Throwable exception) {
    log(BotLogSeverity.WARNING, message, exception);
  }

  @Override
  public void error(String message) {
    log(BotLogSeverity.ERROR, message, null);
  }

  @Override
  public void error(String message, Throwable exception) {
    log(BotLogSeverity.ERROR, message, exception);
  }

  @Override
  public void log(BotLogSeverity severity, String message, Throwable exception) {
    log(new BotLogEntry(severity, message, exception));
  }

  @Override
  public void log(BotLogEntry entry) {
    writeToSink(entry);
  }

  /**
   * Base method to convert log entry to String. Default format would be like Wed, 4 Jul 2001 12:08:56 -0700   INFO This is a test message
   *
   * @param entry log entry
   * @return string representation of log entry
   */
  protected String formatLogEntry(BotLogEntry entry) {
    StrBuilder sb = new StrBuilder();
    sb.append(getDateFormat().format(entry.getTimestamp()));
    sb.appendFixedWidthPadLeft(entry.getSeverity().getAbbreviation(), 7, ' ');
    sb.appendSeparator(' ').append(entry.getMessage());
    return sb.toString();
  }

  /**
   * Return default date format
   *
   * @return default date format
   */
  protected DateFormat getDateFormat() {
    return DATE_FORMAT;
  }

  /**
   * Customizable method which writes log entry to exact resource
   *
   * @param entry log entry
   */
  protected abstract void writeToSink(BotLogEntry entry);

  /**
   * Creates a builder which simplifies the message configuration
   */
  @Override
  public BotLogEntryBuilder composeLogMessage() {
    return new BotLogEntryBuilderImpl(this);
  }

  private class BotLogEntryBuilderImpl implements BotLogEntryBuilder {

    private final AbstractBotLogger logger;
    private final StrBuilder sb = new StrBuilder();
    private final BotLogEntry logEntry = new BotLogEntry();

    private BotLogEntryBuilderImpl(AbstractBotLogger logger) {
      this.logger = logger;
    }

    @Override
    public BotLogEntryBuilder appendWhitespaceSeparator() {
      return appendSeparator(' ');
    }

    @Override
    public BotLogEntryBuilder appendSeparator(char separator) {
      sb.appendSeparator(separator);
      return this;
    }

    @Override
    public BotLogEntryBuilder append(Object obj) {
      sb.append(obj);
      return this;
    }

    @Override
    public BotLogEntryBuilder append(String str) {
      sb.append(str);
      return this;
    }

    @Override
    public BotLogEntryBuilder appendNewLine() {
      sb.appendNewLine();
      return this;
    }

    @Override
    public BotLogEntryBuilder append(int value) {
      sb.append(value);
      return this;
    }

    @Override
    public BotLogEntryBuilder append(long value) {
      sb.append(value);
      return this;
    }

    @Override
    public BotLogEntryBuilder append(float value) {
      sb.append(value);
      return this;
    }

    @Override
    public BotLogEntryBuilder append(double value) {
      sb.append(value);
      return this;
    }

    @Override
    public BotLogEntryBuilder append(boolean value) {
      sb.append(value);
      return this;
    }

    @Override
    public BotLogEntryBuilder append(char ch) {
      sb.append(ch);
      return this;
    }

    @Override
    public BotLogEntryBuilder appendln(Object obj) {
      sb.appendln(obj);
      return this;
    }

    @Override
    public BotLogEntryBuilder appendln(String str) {
      sb.appendln(str);
      return this;
    }

    @Override
    public BotLogEntryBuilder append(String format, Object... objs) {
      sb.append(format, objs);
      return this;
    }

    @Override
    public BotLogEntryBuilder appendln(String format, Object... objs) {
      sb.appendln(format, objs);
      return this;
    }

    @Override
    public BotLogEntryBuilder appendln(boolean value) {
      sb.appendln(value);
      return this;
    }

    @Override
    public BotLogEntryBuilder appendln(char ch) {
      sb.appendln(ch);
      return this;
    }

    @Override
    public BotLogEntryBuilder appendln(int value) {
      sb.appendln(value);
      return this;
    }

    @Override
    public BotLogEntryBuilder appendln(long value) {
      sb.appendln(value);
      return this;
    }

    @Override
    public BotLogEntryBuilder appendln(float value) {
      sb.appendln(value);
      return this;
    }

    @Override
    public BotLogEntryBuilder appendln(double value) {
      sb.appendln(value);
      return this;
    }

    @Override
    public BotLogEntryBuilder appendPadding(int length, char padChar) {
      sb.appendPadding(length, padChar);
      return this;
    }

    @Override
    public BotLogEntryBuilder appendFixedWidthPadLeft(Object obj, int width, char padChar) {
      sb.appendFixedWidthPadLeft(obj, width, padChar);
      return this;
    }

    @Override
    public BotLogEntryBuilder appendFixedWidthPadRight(Object obj, int width, char padChar) {
      sb.appendFixedWidthPadRight(obj, width, padChar);
      return this;
    }

    @Override
    public BotLogEntryBuilder trim() {
      sb.trim();
      return this;
    }

    @Override
    public BotLogEntryBuilder withSeverity(BotLogSeverity severity) {
      logEntry.setSeverity(severity);
      return this;
    }

    @Override
    public BotLogEntryBuilder withException(Throwable exception) {
      logEntry.setException(exception);
      return this;
    }

    @Override
    public void push() {
      logEntry.buildMessage(sb.toString());
      logger.log(logEntry);
    }
  }


}
