package org.msbotframework4j.core.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Microsoft Translator Language Codes
 *
 * @author Maksim Kanev
 */
public enum Language {
  ARABIC("ar", "Arabic"), //
  BOSNIAN("bs-Latn", "Bosnian (Latin)"), //
  BULGARIAN("bg", "Bulgarian"), //
  CATALAN("ca", "Catalan"), //
  CHINESE_SIMPLIFIED("zh-CHS", "Chinese Simplified"), //
  CHINESE_TRADITIONAL("zh-CHT", "Chinese Traditional"), //
  CROATIAN("hr", "Croatian"), //
  CZECH("cs", "Czech"), //
  DANISH("da", "Danish"), //
  DUTCH("nl", "Dutch"), //
  ENGLISH("en", "English"), //
  ESTONIAN("et", "Estonian"), //
  FINNISH("fi", "Finnish"), //
  FRENCH("fr", "French"), //
  GERMAN("de", "German"), //
  GREEK("el", "Greek"), //
  HAITIAN_CREOLE("ht", "Haitian Creole"), //
  HEBREW("he", "Hebrew"), //
  HINDI("hi", "Hindi"), //
  HMONG_DAW("mww", "Hmong Daw"), //
  HUNGARIAN("hu", "Hungarian"), //
  INDONESIAN("id", "Indonesian"), //
  ITALIAN("it", "Italian"), //
  JAPANESE("ja", "Japanese"), //
  KISWAHILI("sw", "Kiswahili"), //
  KLINGON("tlh", "Klingon"), //
  KLINGON_PIQAD("tlh-Qaak", "Klingon (pIqaD)"), //
  KOREAN("ko", "Korean"), //
  LATVIAN("lv", "Latvian"), //
  LITHUANIAN("lt", "Lithuanian"), //
  MALAY("ms", "Malay"), //
  MALTESE("mt", "Maltese"), //
  NORWEGIAN("no", "Norwegian"), //
  PERSIAN("fa", "Persian"), //
  POLISH("pl", "Polish"), //
  PORTUGUESE("pt", "Portuguese"), //
  QUERETARO_OTOMI("otq", "Querétaro Otomi"), //
  ROMANIAN("ro", "Romanian"), //
  RUSSIAN("ru", "Russian"), //
  SERBIAN_CYRILLIC("sr-Cyrl", "Serbian (Cyrillic)"), //
  SERBIAN_LATIN("sr-Latn", "Serbian (Latin)"), //
  SLOVAK("sk", "Slovak"), //
  SLOVENIAN("sl", "Slovenian"), //
  SPANISH("es", "Spanish"), //
  SWEDISH("sv", "Swedish"), //
  THAI("th", "Thai"), //
  TURKISH("tr", "Turkish"), //
  UKRAINIAN("uk", "Ukrainian"), //
  URDU("ur", "Urdu"), //
  VIETNAMESE("vi", "Vietnamese"), //
  WELSH("cy", "Welsh"), //
  YUCATEC_MAYA("yua", "Yucatec Maya"), //
  ;

  private final String code, englishName;

  Language(String code, String englishName) {
    this.code = code;
    this.englishName = englishName;
    Holder.LANGUAGE_CODE_MAP.put(code, this);
  }

  /**
   * {@link JsonCreator} method to convert {@link Message} JSON "language" field value to Language
   *
   * @param code {@link Message} JSON "language" field value
   * @return Language
   */
  @JsonCreator
  public static Language deserialize(String code) {
    return (StringUtils.isBlank(code) ? null : Holder.LANGUAGE_CODE_MAP.get(code));
  }

  /**
   * {@link JsonValue} method to convert Language to {@link Message} JSON "language" field value
   *
   * @return {@link Message} JSON "language" field value
   */
  @JsonValue
  public String getCode() {
    return code;
  }

  public String getEnglishName() {
    return englishName;
  }

  private static class Holder {

    static final Map<String, Language> LANGUAGE_CODE_MAP = new HashMap<>();
  }
}
