package org.msbotframework4j.core.model;

/**
 * Class that represents BotConnector error
 *
 * @author <a href="mailto:maksim.kanev@gmail.com">Maksim Kanev</a>
 */
public class Error {

  /**
   * Error code
   */
  private ErrorCode code;
  /**
   * Error message
   */
  private String message;
  /**
   * Error status code
   */
  private Integer statusCode;

  public ErrorCode getCode() {
    return code;
  }

  public void setCode(ErrorCode code) {
    this.code = code;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Integer getStatusCode() {
    return statusCode;
  }

  public void setStatusCode(Integer statusCode) {
    this.statusCode = statusCode;
  }

  @Override
  public String toString() {
    return "Error{" +
           "code=" + code +
           ", message='" + message + '\'' +
           ", statusCode=" + statusCode +
           '}';
  }
}
