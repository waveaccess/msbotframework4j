package org.msbotframework4j.core.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

/**
 * @author <a href="mailto:maksim.kanev@gmail.com">Maksim Kanev</a>
 */
@SuppressWarnings("WeakerAccess")
@RunWith(Parameterized.class)
public class MessageTypeTest {

  private final ObjectMapper mapper = new ObjectMapper();

  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][]{
        {"Message", MessageType.MESSAGE},
        {"Ping", MessageType.PING},
        {"DeleteUserData", MessageType.DELETE_USER_DATA},
        {"BotAddedToConversation", MessageType.BOT_ADDED_TO_CONVERSATION},
        {"BotRemovedFromConversation", MessageType.BOT_REMOVED_FROM_CONVERSATION},
        {"UserAddedToConversation", MessageType.USER_ADDED_TO_CONVERSATION},
        {"UserRemovedFromConversation", MessageType.USER_REMOVED_FROM_CONVERSATION},
        {"EndOfConversation", MessageType.END_OF_CONVERSATION}
    });
  }

  @Parameterized.Parameter
  public String apiValue;

  @Parameterized.Parameter(value = 1)
  public MessageType innerValue;

  @Test
  public void serializationTest() throws JsonProcessingException {
    Dto d = new Dto();
    d.setType(innerValue);
    String serialized = mapper.writeValueAsString(d);
    Assert.assertEquals(serialized, getDtoString(apiValue));
  }

  @Test
  public void deserializationTest() throws IOException {
    Dto deserialized = mapper.readValue(getDtoString(apiValue), Dto.class);
    Assert.assertEquals(deserialized.type, innerValue);
  }

  private String getDtoString(String apiMessageType) {
    return "{\"type\":\"" + apiMessageType + "\"}";
  }

  public static class Dto {

    private MessageType type;

    public MessageType getType() {
      return type;
    }

    public void setType(MessageType type) {
      this.type = type;
    }
  }

}
