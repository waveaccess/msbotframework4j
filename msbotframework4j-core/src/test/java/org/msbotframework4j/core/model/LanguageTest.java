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
public class LanguageTest {

  private final ObjectMapper mapper = new ObjectMapper();

  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][]{
        {"ar", Language.ARABIC}, //
        {"bs-Latn", Language.BOSNIAN}, //
        {"bg", Language.BULGARIAN}, //
        {"ca", Language.CATALAN}, //
        {"zh-CHS", Language.CHINESE_SIMPLIFIED}, //
        {"zh-CHT", Language.CHINESE_TRADITIONAL}, //
        {"hr", Language.CROATIAN}, //
        {"cs", Language.CZECH}, //
        {"da", Language.DANISH}, //
        {"nl", Language.DUTCH}, //
        {"en", Language.ENGLISH}, //
        {"et", Language.ESTONIAN}, //
        {"fi", Language.FINNISH}, //
        {"fr", Language.FRENCH}, //
        {"de", Language.GERMAN}, //
        {"el", Language.GREEK}, //
        {"ht", Language.HAITIAN_CREOLE}, //
        {"he", Language.HEBREW}, //
        {"hi", Language.HINDI}, //
        {"mww", Language.HMONG_DAW}, //
        {"hu", Language.HUNGARIAN}, //
        {"id", Language.INDONESIAN}, //
        {"it", Language.ITALIAN}, //
        {"ja", Language.JAPANESE}, //
        {"sw", Language.KISWAHILI}, //
        {"tlh", Language.KLINGON}, //
        {"tlh-Qaak", Language.KLINGON_PIQAD}, //
        {"ko", Language.KOREAN}, //
        {"lv", Language.LATVIAN}, //
        {"lt", Language.LITHUANIAN}, //
        {"ms", Language.MALAY}, //
        {"mt", Language.MALTESE}, //
        {"no", Language.NORWEGIAN}, //
        {"fa", Language.PERSIAN}, //
        {"pl", Language.POLISH}, //
        {"pt", Language.PORTUGUESE}, //
        {"otq", Language.QUERETARO_OTOMI}, //
        {"ro", Language.ROMANIAN}, //
        {"ru", Language.RUSSIAN}, //
        {"sr-Cyrl", Language.SERBIAN_CYRILLIC}, //
        {"sr-Latn", Language.SERBIAN_LATIN}, //
        {"sk", Language.SLOVAK}, //
        {"sl", Language.SLOVENIAN}, //
        {"es", Language.SPANISH}, //
        {"sv", Language.SWEDISH}, //
        {"th", Language.THAI}, //
        {"tr", Language.TURKISH}, //
        {"uk", Language.UKRAINIAN}, //
        {"ur", Language.URDU}, //
        {"vi", Language.VIETNAMESE}, //
        {"cy", Language.WELSH}, //
        {"yua", Language.YUCATEC_MAYA}, //
    });
  }

  @Parameterized.Parameter
  public String apiValue;

  @Parameterized.Parameter(value = 1)
  public Language innerValue;

  @Test
  public void serializationTest() throws JsonProcessingException {
    Dto d = new Dto();
    d.setLanguage(innerValue);
    String serialized = mapper.writeValueAsString(d);
    Assert.assertEquals(serialized, getDtoString(apiValue));
  }

  @Test
  public void deserializationTest() throws IOException {
    Dto deserialized = mapper.readValue(getDtoString(apiValue), Dto.class);
    Assert.assertEquals(deserialized.language, innerValue);
  }

  private String getDtoString(String apiMessageType) {
    return "{\"language\":\"" + apiMessageType + "\"}";
  }

  public static class Dto {

    private Language language;

    public Language getLanguage() {
      return language;
    }

    public void setLanguage(Language language) {
      this.language = language;
    }
  }

}
