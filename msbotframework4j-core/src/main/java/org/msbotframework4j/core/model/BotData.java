package org.msbotframework4j.core.model;

/**
 * Class that represents Bot state in BotConnector persistent storage
 *
 * @author <a href="mailto:maksim.kanev@gmail.com">Maksim Kanev</a>
 */
public final class BotData extends GenericApiEntity {

  /**
   * State data (OPTIONAL)
   */
  private Object data;
  /**
   * (OPTIONAL)
   */
  private String eTag;

  public Object getData() {
    return data;
  }

  public void setData(Object data) {
    this.data = data;
  }

  public String geteTag() {
    return eTag;
  }

  public void seteTag(String eTag) {
    this.eTag = eTag;
  }

  @Override
  public String toString() {
    return "BotData{" +
           "data=" + data +
           ", eTag='" + eTag + '\'' +
           "} " + super.toString();
  }
}
