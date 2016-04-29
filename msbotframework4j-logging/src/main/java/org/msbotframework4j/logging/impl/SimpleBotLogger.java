package org.msbotframework4j.logging.impl;

import org.msbotframework4j.logging.AbstractBotLogger;
import org.msbotframework4j.logging.BotLogEntry;
import org.msbotframework4j.logging.BotLogger;

/**
 * Simple implementation of {@link BotLogger} that prints messages to System.out
 *
 * @author <a href="mailto:maksim.kanev@gmail.com">Maksim Kanev</a>
 */
public class SimpleBotLogger extends AbstractBotLogger {

  @Override
  protected void writeToSink(BotLogEntry entry) {
    System.out.println(formatLogEntry(entry));
  }
}
