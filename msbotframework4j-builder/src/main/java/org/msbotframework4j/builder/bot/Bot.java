package org.msbotframework4j.builder.bot;

import org.msbotframework4j.core.model.Message;
import org.msbotframework4j.logging.BotLogger;

/**
 * @author Maksim Kanev
 */
public interface Bot {

  Message getReply(Message message, BotLogger logger);
}
