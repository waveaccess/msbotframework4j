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
 * @author <a href="mailto:maksim.kanev@gmail.com">Maksim Kanev</a>
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
    InputStreamReader inputStreamReader = new InputStreamReader(src, StandardCharsets.UTF_8);
    T json = GSON.fromJson(inputStreamReader, clazz);
    inputStreamReader.close();
    src.close();
    return json;
  }

  public static void toJson(OutputStream out, Class<?> clazz, Object value) throws IOException {
    OutputStreamWriter outputStreamWriter = new OutputStreamWriter(out, StandardCharsets.UTF_8);
    GSON.toJson(value, clazz, outputStreamWriter);
    outputStreamWriter.close();
    out.close();
  }

  public static <T> T fromJsonString(Class<T> clazz, String value) {
    return GSON.fromJson(value, clazz);
  }

  public static String toJsonString(Class<?> clazz, Object value) {
    return GSON.toJson(value, clazz);
  }
}
