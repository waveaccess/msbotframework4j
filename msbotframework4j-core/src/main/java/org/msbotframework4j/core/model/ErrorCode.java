package org.msbotframework4j.core.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.text.WordUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Class that represents BotConnector's error codes
 *
 * @author <a href="mailto:maksim.kanev@gmail.com">Maksim Kanev</a>
 */
public enum ErrorCode {
  MISSING_PROPERTY,
  MALFORMED_DATA,
  NOT_FOUND,
  SERVICE_ERROR,
  INTERNAL,
  INVALID_RANGE,
  NOT_SUPPORTED,
  NOT_ALLOWED,
  BAD_CERTIFICATE;

  ErrorCode() {
    Holder.CONDENSED_KEY_MAP.put(StringUtils.remove(name(), '_'), this);
  }

  /**
   * {@link JsonCreator} method to convert {@link Error} JSON "errorCode" field value to ErrorCode
   *
   * @param input {@link Error} JSON "errorCode" field value
   * @return ErrorCode
   */
  @JsonCreator
  public static ErrorCode deserialize(String input) {
    return StringUtils.isBlank(input) ? null : Holder.CONDENSED_KEY_MAP.get(StringUtils.upperCase(input));
  }

  /**
   * {@link JsonValue} method to convert ErrorCode to {@link Error} JSON "errorCode" field value
   *
   * @return {@link Error} JSON "errorCode" field value
   */
  @JsonValue
  public String serialize() {
    return StringUtils.remove(WordUtils.capitalizeFully(name(), '_'), '_');
  }

  private static class Holder {

    static final Map<String, ErrorCode> CONDENSED_KEY_MAP = new HashMap<>();
  }
}
