package org.msbotframework4j.core.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Channel type that the {@link ChannelAccount} is to be communicated with
 *
 * @author <a href="mailto:maksim.kanev@gmail.com">Maksim Kanev</a>
 */
public enum ChannelType {
  TEST,
  EMULATOR,
  EMAIL,
  GROUP_ME,
  SKYPE,
  SLACK,
  SMS,
  TELEGRAM,
  WEB;

  ChannelType() {
    ChannelType.Holder.UPPERCASE_KEY_MAP.put(StringUtils.remove(name(), '_'), this);
  }

  /**
   * {@link JsonCreator} method to convert {@link ChannelAccount} JSON "channelId" field value to ChannelType
   *
   * @param input {@link ChannelAccount} JSON "channelId" field value
   * @return ChannelType
   */
  @JsonCreator
  public static ChannelType deserialize(String input) {
    return StringUtils.isBlank(input) ? null : ChannelType.Holder.UPPERCASE_KEY_MAP.get(StringUtils.upperCase(input));
  }

  /**
   * {@link JsonValue} method to convert ChannelType to {@link ChannelAccount} JSON "channelId" field value
   *
   * @return {@link ChannelAccount} JSON "channelId" field value
   */
  @JsonValue
  public String serialize() {
    return StringUtils.remove(StringUtils.lowerCase(name()), '_');
  }

  private static class Holder {

    static final Map<String, ChannelType> UPPERCASE_KEY_MAP = new HashMap<>();
  }
}
