package org.msbotframework4j.builder.bot.telegram;

import org.apache.commons.lang3.StringUtils;
import org.msbotframework4j.builder.bot.AbstractBot;
import org.msbotframework4j.core.model.Message;
import org.msbotframework4j.logging.BotLogger;

/**
 * Base class for Telegram Bots
 *
 * @author <a href="mailto:maksim.kanev@gmail.com">Maksim Kanev</a>
 */
public class AbstractTelegramBot extends AbstractBot {

  private final String CMD_START = "/start";

  @Override
  protected final Message onMessage(Message request, BotLogger logger) {
    return StringUtils.isNotBlank(request.getText()) ? onCommandReceived(request, logger) : onAttachmentReceived(request, logger);
  }

  private Message onCommandReceived(Message request, BotLogger logger) {
    return StringUtils.equals(CMD_START, request.getText()) ? onConversationStarted(request, logger) : onCustomCommandReceived(request, logger);
  }

  private Message onConversationStarted(Message request, BotLogger logger) {
    return null;
  }

  private Message onCustomCommandReceived(Message request, BotLogger logger) {
    return null;
  }

  private Message onAttachmentReceived(Message request, BotLogger logger) {
    return null;
  }
}
