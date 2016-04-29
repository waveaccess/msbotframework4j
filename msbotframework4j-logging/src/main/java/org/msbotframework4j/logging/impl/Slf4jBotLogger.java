package org.msbotframework4j.logging.impl;


import org.apache.commons.lang3.text.StrBuilder;
import org.msbotframework4j.logging.AbstractBotLogger;
import org.msbotframework4j.logging.BotLogEntry;
import org.slf4j.Logger;

/**
 * Adapter for Slf4j logging system
 *
 * @author <a href="mailto:maksim.kanev@gmail.com">Maksim Kanev</a>
 */
public class Slf4jBotLogger extends AbstractBotLogger {

  private final Logger logger;

  public Slf4jBotLogger(Logger logger) {
    this.logger = logger;
  }

  @Override
  protected void writeToSink(BotLogEntry entry) {
    String logEntry = formatLogEntry(entry);
    switch (entry.getSeverity()) {
      case DEBUG:
        if (logger.isDebugEnabled()) {
          logger.debug(logEntry);
        }
        break;
      case INFO:
        if (logger.isInfoEnabled()) {
          logger.info(logEntry);
        }
        break;
      case WARNING:
        if (logger.isWarnEnabled()) {
          logger.warn(logEntry);
        }
        break;
      case ERROR:
        if (logger.isErrorEnabled()) {
          logger.error(logEntry);
        }
        break;
    }
  }

  @Override
  protected String formatLogEntry(BotLogEntry entry) {
    StrBuilder sb = new StrBuilder();
    sb.append(getDateFormat().format(entry.getTimestamp()));
    sb.append(entry.getMessage());
    return sb.toString();
  }
}
