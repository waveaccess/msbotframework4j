package org.msbotframework4j.builder.wrapper;

import com.google.common.io.ByteSource;

import com.amazonaws.services.lambda.runtime.Context;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.msbotframework4j.builder.bot.Bot;
import org.msbotframework4j.builder.wrapper.support.LambdaContext;
import org.msbotframework4j.core.json.SerializerFacade;
import org.msbotframework4j.core.model.Message;
import org.msbotframework4j.core.model.MessageType;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author <a href="mailto:maksim.kanev@gmail.com">Maksim Kanev</a>
 */
@RunWith(Parameterized.class)
public class ServerlessBotWrapperSpecialCasesTest {

  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][]{
        {MessageType.PING, MessageType.MESSAGE, Bot.PING_RESPONSE_TEXT},
        {MessageType.DELETE_USER_DATA, MessageType.MESSAGE, Bot.NOT_SUPPORTED_TYPE_RESPONSE_TEXT},
        {MessageType.BOT_ADDED_TO_CONVERSATION, MessageType.MESSAGE, Bot.BOT_ADDED_TO_CONVERSATION_RESPONSE_TEXT},
        {MessageType.BOT_REMOVED_FROM_CONVERSATION, MessageType.MESSAGE, Bot.BOT_REMOVED_FROM_CONVERSATION_RESPONSE_TEXT},
        {MessageType.USER_ADDED_TO_CONVERSATION, MessageType.MESSAGE, Bot.NOT_SUPPORTED_TYPE_RESPONSE_TEXT},
        {MessageType.USER_REMOVED_FROM_CONVERSATION, MessageType.MESSAGE, Bot.NOT_SUPPORTED_TYPE_RESPONSE_TEXT},
        {MessageType.END_OF_CONVERSATION, MessageType.MESSAGE, Bot.END_OF_CONVERSATION_RESPONSE_TEXT},
        });
  }

  @Parameterized.Parameter(value = 0)
  public MessageType requestMessageType;
  @Parameterized.Parameter(value = 1)
  public MessageType responseMessageType;
  @Parameterized.Parameter(value = 2)
  public String responseText;

  @Test
  public void handleRequest() throws Exception {
    ServerlessBotWrapper requestHandler = new ServerlessBotWrapper();
    Message msg = new Message();
    msg.setType(requestMessageType);
    InputStream input = ByteSource.wrap(
        SerializerFacade.toJsonString(Message.class, msg)
            .getBytes(StandardCharsets.UTF_8)
    ).openStream();
    ByteArrayOutputStream output = new ByteArrayOutputStream();
    Context context = new LambdaContext();
    requestHandler.handleRequest(input, output, context);
    Message message = SerializerFacade.fromJson(ByteSource.wrap(output.toByteArray()).openStream(), Message.class);
    assertThat(message.getType()).isEqualTo(responseMessageType);
    assertThat(message.getText()).isEqualTo(responseText);
  }

}
