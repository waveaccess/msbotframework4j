package org.msbotframework4j.core.model;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.msbotframework4j.core.json.SerializerFacade;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

/**
 * @author <a href="mailto:maksim.kanev@gmail.com">Maksim Kanev</a>
 */
@SuppressWarnings("WeakerAccess")
@RunWith(Parameterized.class)
public class ChannelTypeTest {

  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][]{
        {"test", ChannelType.TEST},
        {"email", ChannelType.EMAIL},
        {"groupme", ChannelType.GROUP_ME},
        {"skype", ChannelType.SKYPE},
        {"slack", ChannelType.SLACK},
        {"sms", ChannelType.SMS},
        {"telegram", ChannelType.TELEGRAM},
        {"web", ChannelType.WEB},
        {"emulator", ChannelType.EMULATOR},
        });
  }

  @Parameterized.Parameter
  public String apiValue;

  @Parameterized.Parameter(value = 1)
  public ChannelType innerValue;

  @Test
  public void serializationTest() {
    Dto d = new Dto();
    d.setChannelId(innerValue);
    String serialized = SerializerFacade.toJsonString(Dto.class, d);
    Assert.assertEquals(serialized, getDtoString(apiValue));
  }

  @Test
  public void deserializationTest() throws IOException {
    Dto deserialized = SerializerFacade.fromJsonString(Dto.class, getDtoString(apiValue));
    Assert.assertEquals(deserialized.channelId, innerValue);
  }

  private String getDtoString(String apiMessageType) {
    return "{\"channelId\":\"" + apiMessageType + "\"}";
  }

  public static class Dto {

    private ChannelType channelId;

    public ChannelType getChannelId() {
      return channelId;
    }

    public void setChannelId(ChannelType channelId) {
      this.channelId = channelId;
    }
  }

}
