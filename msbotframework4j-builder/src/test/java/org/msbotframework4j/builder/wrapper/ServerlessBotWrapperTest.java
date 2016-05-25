package org.msbotframework4j.builder.wrapper;

import com.google.common.io.ByteSource;

import com.amazonaws.services.lambda.runtime.Context;

import org.junit.Test;
import org.msbotframework4j.builder.bot.Bot;
import org.msbotframework4j.builder.wrapper.support.LambdaContext;
import org.msbotframework4j.core.json.SerializerFacade;
import org.msbotframework4j.core.model.Message;
import org.msbotframework4j.core.model.MessageType;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author <a href="mailto:maksim.kanev@gmail.com">Maksim Kanev</a>
 */
public class ServerlessBotWrapperTest {

  @Test
  public void handleRequest() throws Exception {
    ServerlessBotWrapper requestHandler = new ServerlessBotWrapper();
    Message msg = new Message();
    msg.setType(MessageType.PING);
    InputStream input = ByteSource.wrap(
        SerializerFacade.toJsonString(Message.class, msg)
            .getBytes(StandardCharsets.UTF_8)
    ).openStream();
    ByteArrayOutputStream output = new ByteArrayOutputStream();
    Context context = new LambdaContext();
    requestHandler.handleRequest(input, output, context);
    Message message = SerializerFacade.fromJson(ByteSource.wrap(output.toByteArray()).openStream(), Message.class);
    assertThat(message.getType()).isEqualTo(MessageType.MESSAGE);
    assertThat(message.getText()).isEqualTo(Bot.PING_RESPONSE_TEXT);
  }

}
