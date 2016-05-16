package org.msbotframework4j.core.model;

/**
 * Class that represents mentions from the channel context
 *
 * @author <a href="mailto:maksim.kanev@gmail.com">Maksim Kanev</a>
 */
public final class Mention {

  /**
   * The mentioned user
   */
  private ChannelAccount mentioned;
  /**
   * Sub Text which represents the mention (can be null or empty)
   */
  private String text;

  public ChannelAccount getMentioned() {
    return mentioned;
  }

  public void setMentioned(ChannelAccount mentioned) {
    this.mentioned = mentioned;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  @Override
  public String toString() {
    return "Mention{" +
           "mentioned=" + mentioned +
           ", text='" + text + '\'' +
           '}';
  }
}
