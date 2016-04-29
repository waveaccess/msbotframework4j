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
public class ErrorCodeTest {

  private final ObjectMapper mapper = new ObjectMapper();

  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][]{
        {"MissingProperty", ErrorCode.MISSING_PROPERTY},
        {"MalformedData", ErrorCode.MALFORMED_DATA},
        {"NotFound", ErrorCode.NOT_FOUND},
        {"ServiceError", ErrorCode.SERVICE_ERROR},
        {"Internal", ErrorCode.INTERNAL},
        {"InvalidRange", ErrorCode.INVALID_RANGE},
        {"NotSupported", ErrorCode.NOT_SUPPORTED},
        {"NotAllowed", ErrorCode.NOT_ALLOWED},
        {"BadCertificate", ErrorCode.BAD_CERTIFICATE},
    });
  }

  @Parameterized.Parameter
  public String apiValue;

  @Parameterized.Parameter(value = 1)
  public ErrorCode innerValue;

  @Test
  public void serializationTest() throws JsonProcessingException {
    Dto d = new Dto();
    d.setCode(innerValue);
    String serialized = mapper.writeValueAsString(d);
    Assert.assertEquals(serialized, getDtoString(apiValue));
  }

  @Test
  public void deserializationTest() throws IOException {
    Dto deserialized = mapper.readValue(getDtoString(apiValue), Dto.class);
    Assert.assertEquals(deserialized.code, innerValue);
  }

  private String getDtoString(String apiMessageType) {
    return "{\"code\":\"" + apiMessageType + "\"}";
  }

  public static class Dto {

    private ErrorCode code;

    public ErrorCode getCode() {
      return code;
    }

    public void setCode(ErrorCode code) {
      this.code = code;
    }
  }

}
