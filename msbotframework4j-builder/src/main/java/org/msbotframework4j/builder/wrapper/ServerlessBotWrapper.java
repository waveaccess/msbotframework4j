package org.msbotframework4j.builder.wrapper;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;

import org.msbotframework4j.core.model.Message;
import org.msbotframework4j.logging.AbstractBotLogger;
import org.msbotframework4j.logging.BotLogEntry;
import org.msbotframework4j.logging.BotLogger;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author Maksim Kanev
 */
public class ServerlessBotWrapper extends AbstractBotWrapper implements RequestStreamHandler {

  @Override
  public void handleRequest(InputStream input, OutputStream output, Context context) throws IOException {
    LambdaBotLogger botLogger = new LambdaBotLogger(context.getLogger());
    Message message = readMessage(input);
    Message replyMessage = getReply(message, botLogger);
    writeMessage(output, replyMessage);
  }

  /**
   * Logging system implementation for AWS Lambda logger (by default writes to AWS CloudWatch)
   */
  private class LambdaBotLogger extends AbstractBotLogger implements BotLogger {

    private final LambdaLogger lambdaLogger;

    private LambdaBotLogger(LambdaLogger lambdaLogger) {
      this.lambdaLogger = lambdaLogger;
    }

    @Override
    protected void writeToSink(BotLogEntry entry) {
      this.lambdaLogger.log(formatLogEntry(entry));
    }
  }

}
