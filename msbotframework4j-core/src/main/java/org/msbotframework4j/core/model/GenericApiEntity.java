package org.msbotframework4j.core.model;

/**
 * Base class for every BotConnector API entity
 *
 * @author <a href="mailto:maksim.kanev@gmail.com">Maksim Kanev</a>
 */
public class GenericApiEntity {

  /**
   * BotConnector error (OPTIONAL)
   */
  private Error error;

  public Error getError() {
    return error;
  }

  public void setError(Error error) {
    this.error = error;
  }

  @Override
  public String toString() {
    return "GenericApiEntity{" +
           "error=" + error +
           '}';
  }
}
