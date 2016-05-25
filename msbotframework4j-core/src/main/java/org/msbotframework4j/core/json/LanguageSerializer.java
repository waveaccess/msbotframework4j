package org.msbotframework4j.core.json;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import org.msbotframework4j.core.model.Language;

import java.lang.reflect.Type;

/**
 * @author <a href="mailto:maksim.kanev@gmail.com">Maksim Kanev</a>
 */
public class LanguageSerializer implements JsonSerializer<Language>, JsonDeserializer<Language> {

  @Override
  public JsonElement serialize(Language src, Type typeOfSrc, JsonSerializationContext context) {
    return new JsonPrimitive(src.serialize());
  }

  @Override
  public Language deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
    return Language.deserialize(json.getAsString());
  }
}
