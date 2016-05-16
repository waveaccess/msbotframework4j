package org.msbotframework4j.core.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.msbotframework4j.core.model.ChannelType;
import org.msbotframework4j.core.model.ErrorCode;
import org.msbotframework4j.core.model.Language;
import org.msbotframework4j.core.model.MessageType;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

/**
 * @author Maksim Kanev
 */
public final class SerializerFacade {

  private static final Gson GSON;

  static {
    GSON = new GsonBuilder()
        .registerTypeAdapter(MessageType.class, new MessageTypeSerializer())
        .registerTypeAdapter(ChannelType.class, new ChannelTypeSerializer())
        .registerTypeAdapter(Language.class, new LanguageSerializer())
        .registerTypeAdapter(ErrorCode.class, new ErrorCodeSerializer())
        .create();
  }

  private SerializerFacade() {
  }

  public static <T> T fromJson(InputStream src, Class<T> clazz) throws IOException {
    return GSON.fromJson(new InputStreamReader(src, StandardCharsets.UTF_8), clazz);
  }

  public static void toJson(OutputStream out, Class<?> clazz, Object value) throws IOException {
    GSON.toJson(value, clazz, new OutputStreamWriter(out, StandardCharsets.UTF_8));
  }

  public static <T> T fromJsonString(Class<T> clazz, String value) {
    return GSON.fromJson(value, clazz);
  }

  public static String toJsonString(Class<?> clazz, Object value) {
    return GSON.toJson(value, clazz);
  }
}
