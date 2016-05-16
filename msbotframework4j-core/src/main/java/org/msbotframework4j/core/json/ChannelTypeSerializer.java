package org.msbotframework4j.core.json;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import org.msbotframework4j.core.model.ChannelType;

import java.lang.reflect.Type;

/**
 * @author Maksim Kanev
 */
public class ChannelTypeSerializer implements JsonSerializer<ChannelType>, JsonDeserializer<ChannelType> {

  @Override
  public JsonElement serialize(ChannelType src, Type typeOfSrc, JsonSerializationContext context) {
    return new JsonPrimitive(src.serialize());
  }

  @Override
  public ChannelType deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
    return ChannelType.deserialize(json.getAsString());
  }
}
