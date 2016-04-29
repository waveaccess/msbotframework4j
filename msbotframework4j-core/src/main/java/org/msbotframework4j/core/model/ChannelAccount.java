package org.msbotframework4j.core.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * Class that represents a conversation participant's account
 *
 * @author <a href="mailto:maksim.kanev@gmail.com">Maksim Kanev</a>
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public final class ChannelAccount {

  /**
   * Display friendly name of the user or bot
   */
  private String name;
  /**
   * Channel Id that the channelAccount is to be communicated with (Example: slack, sms, email, groupme, skype, etc.)
   */
  private ChannelType channelId;
  /**
   * Channel Address for the channelAccount (Example: joe@smith.com, or @joesmith or 123456)
   */
  private String address;
  /**
   * Id - id of the shared bot or user this channelaccount refers to
   */
  private String id;
  /**
   * Is this id a bot?
   */
  @JsonProperty("isBot")
  private boolean bot;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ChannelType getChannelId() {
    return channelId;
  }

  public void setChannelId(ChannelType channelId) {
    this.channelId = channelId;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  public boolean isBot() {
    return bot;
  }

  public void setBot(boolean bot) {
    this.bot = bot;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ChannelAccount that = (ChannelAccount) o;
    return channelId == that.channelId &&
           Objects.equals(address, that.address) &&
           Objects.equals(id, that.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(channelId, address, id);
  }

  @Override
  public String toString() {
    return "ChannelAccount{" +
           "name='" + name + '\'' +
           ", channelId=" + channelId +
           ", address='" + address + '\'' +
           ", id='" + id + '\'' +
           ", bot=" + bot +
           '}';
  }
}
