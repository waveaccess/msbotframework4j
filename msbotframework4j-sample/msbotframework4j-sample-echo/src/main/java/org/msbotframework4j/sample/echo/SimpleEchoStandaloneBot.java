package org.msbotframework4j.sample.echo;

import org.msbotframework4j.builder.bot.AbstractBot;
import org.msbotframework4j.core.model.Message;
import org.msbotframework4j.logging.BotLogger;

/**
 * @author <a href="mailto:maksim.kanev@gmail.com">Maksim Kanev</a>
 */
public class SimpleEchoStandaloneBot extends AbstractBot {

  @Override
  protected Message onMessage(Message request, BotLogger logger) {
    return request.createReplyMessage(request.getText());
  }
}
