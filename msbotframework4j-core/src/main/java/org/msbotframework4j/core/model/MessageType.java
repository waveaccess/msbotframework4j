package org.msbotframework4j.core.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.text.WordUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Class that represents type of a {@link Message}
 *
 * @author <a href="mailto:maksim.kanev@gmail.com">Maksim Kanev</a>
 */
public enum MessageType {
  /**
   * a simple communication between a user &lt;-&gt; bot
   */
  MESSAGE,
  /**
   * A system request to test system availability
   */
  PING,
  /**
   * A compliance request from the the user to delete any profile / user data
   */
  DELETE_USER_DATA,
  /**
   * your bot was added to a conversation
   */
  BOT_ADDED_TO_CONVERSATION,
  /**
   * The bot was removed from a conversation
   */
  BOT_REMOVED_FROM_CONVERSATION,
  /**
   * A notification that a new user has been added to a conversation
   */
  USER_ADDED_TO_CONVERSATION,
  /**
   * A notification that a user has been removed from a conversation
   */
  USER_REMOVED_FROM_CONVERSATION,
  /**
   * A message that indicates that a participant is ending the conversation
   */
  END_OF_CONVERSATION;

  MessageType() {
    Holder.CONDENSED_KEY_MAP.put(StringUtils.remove(name(), '_'), this);
  }

  /**
   * {@link JsonCreator} method to convert {@link Message} JSON "type" field value to MessageType
   *
   * @param input {@link Message} JSON "type" field value
   * @return ChannelType
   */
  @JsonCreator
  public static MessageType deserialize(String input) {
    return StringUtils.isBlank(input) ? null : Holder.CONDENSED_KEY_MAP.get(StringUtils.upperCase(input));
  }

  /**
   * {@link JsonValue} method to convert MessageType to {@link Message} JSON "type" field value
   *
   * @return {@link Message} JSON "type" field value
   */
  @JsonValue
  public String serialize() {
    return StringUtils.remove(WordUtils.capitalizeFully(name(), '_'), '_');
  }

  private static class Holder {

    static final Map<String, MessageType> CONDENSED_KEY_MAP = new HashMap<>();
  }
}
