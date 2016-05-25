package org.msbotframework4j.builder.wrapper;

import org.apache.http.HttpStatus;
import org.apache.http.entity.ContentType;
import org.msbotframework4j.core.model.Message;
import org.msbotframework4j.logging.impl.Slf4jBotLogger;
import org.slf4j.LoggerFactory;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

/**
 * @author <a href="mailto:maksim.kanev@gmail.com">Maksim Kanev</a>
 */
public class StandaloneBotWrapper extends AbstractBotWrapper implements Route {

  private final Object startupShutdownMonitor = new Object();
  private Thread shutdownHook;
  private int port = 13001;

  @Override
  public Object handle(Request request, Response response) throws Exception {
    Slf4jBotLogger botLogger = new Slf4jBotLogger(LoggerFactory.getLogger(StandaloneBotWrapper.class));
    Message message = readMessage(request.raw().getInputStream(), botLogger);
    Message replyMessage = getReply(message, botLogger);
    response.status(HttpStatus.SC_OK);
    response.type(ContentType.APPLICATION_JSON.getMimeType());
    return writeMessageAsString(replyMessage);
  }

  public StandaloneBotWrapper withPort(int port) {
    this.port = port;
    return this;
  }

  public final void start() {
    registerShutdownHook();
    init();
  }

  private void init() {
    Spark.port(port);
    Spark.post("/api/messages", ContentType.APPLICATION_JSON.getMimeType(), this);
  }

  public final void stop() {
    Spark.stop();
  }

  private void registerShutdownHook() {
    if (this.shutdownHook == null) {
      this.shutdownHook = new Thread() {
        @Override
        public void run() {
          synchronized (startupShutdownMonitor) {
            Spark.stop();
          }
        }
      };
      Runtime.getRuntime().addShutdownHook(this.shutdownHook);
    }
  }

}
