package org.msbotframework4j.core.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
import java.util.Objects;

/**
 * Class that represents the object that is used to communicate between a user and a bot
 *
 * @author <a href="mailto:maksim.kanev@gmail.com">Maksim Kanev</a>
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public final class Message extends GenericApiEntity {

  /**
   * The type of the message = ['Message', 'Ping', 'DeleteUserData', 'BotAddedToConversation', 'BotRemovedFromConversation', 'UserAddedToConversation', 'UserRemovedFromConversation', 'EndOfConversation'] (OPTIONAL)
   */
  private MessageType type = MessageType.MESSAGE;
  /**
   * Id for the message (always assigned by transport) (OPTIONAL)
   */
  private String id;
  /**
   * Bot.Connector ConverationId id (always assigned by transport) (OPTIONAL)
   */
  private String conversationId;
  /**
   * Timestamp of when the message was created (OPTIONAL)
   */
  private String created;
  /**
   * (if translated) The OriginalText of the message (OPTIONAL)
   */
  private String sourceText;
  /**
   * (if translated) The language of the original message (OPTIONAL)
   */
  private Language sourceLanguage;
  /**
   * The language code of the Text field The language your message is expressed in (important if you have translation enabled) using the language codes from Microsoft Translator {@link https://msdn.microsoft.com/en-us/library/hh456380.aspx} (OPTIONAL)
   */
  private Language language;
  /**
   * The text of the message (OPTIONAL)
   */
  private String text;
  /**
   * Array of content attachments to things like images Attachments represent images and attachments that will be rendered on the platform as appropriate (OPTIONAL)
   */
  private List<Attachment> attachments;
  /**
   * ChannelAccount of the user or bot that is sending the message (OPTIONAL)
   */
  private ChannelAccount from;
  /**
   * ChannelAccount of the user or bot the message is being routed to (OPTIONAL)
   */
  private ChannelAccount to;
  /**
   * The message Id that this message is a reply to (OPTIONAL)
   */
  private String replyToMessageId;
  /**
   * List of ChannelAccounts in the conversation (OPTIONAL)
   */
  private List<ChannelAccount> participants;
  /**
   * Total participants in the conversation. 2 means 1:1 message User - Bot (OPTIONAL)
   */
  private Integer totalParticipants;
  /**
   * Array of mentions from the channel context (OPTIONAL)
   */
  private List<Mention> mentions;
  /**
   * Place in user readable format (OPTIONAL)
   */
  private String place;
  /**
   * Channel Message Id (OPTIONAL)
   */
  private String channelMessageId;
  /**
   * Channel Conversation Id (OPTIONAL)
   */
  private String channelConversationId;
  /**
   * Channel specific payload You can pass channel specific data to get custom native rendering of your message on a per channel basis. See channel documentation for information on what channels are expecting for this (OPTIONAL)
   */
  private Object channelData;
  /**
   * Bot's User data object Bot controlled Object which is tracked on the user regardless of the channel they communicate on (OPTIONAL)
   */
  private BotData botUserData;
  /**
   * Bot's Conversation Data object Bot controlled object which is tracked on the conversation regardless of the user you are talking to (OPTIONAL)
   */
  private BotData botConversationData;
  /**
   * Bot's Per User in a conversation data object Bot controlled object which is tracked on a user in a given conversation (OPTIONAL)
   */
  private BotData botPerUserInConversationData;
  /**
   * Location information {@link https://dev.onedrive.com/facets/location_facet.htm} (OPTIONAL)
   */
  private Location location;
  /**
   * Hashtags for the message (OPTIONAL)
   */
  private List<String> hashtags;
  /**
   * (OPTIONAL)
   */
  private String eTag;

  public MessageType getType() {
    return type;
  }

  public void setType(MessageType type) {
    this.type = type;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getConversationId() {
    return conversationId;
  }

  public void setConversationId(String conversationId) {
    this.conversationId = conversationId;
  }

  public String getCreated() {
    return created;
  }

  public void setCreated(String created) {
    this.created = created;
  }

  public String getSourceText() {
    return sourceText;
  }

  public void setSourceText(String sourceText) {
    this.sourceText = sourceText;
  }

  public Language getSourceLanguage() {
    return sourceLanguage;
  }

  public void setSourceLanguage(Language sourceLanguage) {
    this.sourceLanguage = sourceLanguage;
  }

  public Language getLanguage() {
    return language;
  }

  public void setLanguage(Language language) {
    this.language = language;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public List<Attachment> getAttachments() {
    return attachments;
  }

  public void setAttachments(List<Attachment> attachments) {
    this.attachments = attachments;
  }

  public ChannelAccount getFrom() {
    return from;
  }

  public void setFrom(ChannelAccount from) {
    this.from = from;
  }

  public ChannelAccount getTo() {
    return to;
  }

  public void setTo(ChannelAccount to) {
    this.to = to;
  }

  public String getReplyToMessageId() {
    return replyToMessageId;
  }

  public void setReplyToMessageId(String replyToMessageId) {
    this.replyToMessageId = replyToMessageId;
  }

  public List<ChannelAccount> getParticipants() {
    return participants;
  }

  public void setParticipants(List<ChannelAccount> participants) {
    this.participants = participants;
  }

  public Integer getTotalParticipants() {
    return totalParticipants;
  }

  public void setTotalParticipants(Integer totalParticipants) {
    this.totalParticipants = totalParticipants;
  }

  public List<Mention> getMentions() {
    return mentions;
  }

  public void setMentions(List<Mention> mentions) {
    this.mentions = mentions;
  }

  public String getPlace() {
    return place;
  }

  public void setPlace(String place) {
    this.place = place;
  }

  public String getChannelMessageId() {
    return channelMessageId;
  }

  public void setChannelMessageId(String channelMessageId) {
    this.channelMessageId = channelMessageId;
  }

  public String getChannelConversationId() {
    return channelConversationId;
  }

  public void setChannelConversationId(String channelConversationId) {
    this.channelConversationId = channelConversationId;
  }

  public Object getChannelData() {
    return channelData;
  }

  public void setChannelData(Object channelData) {
    this.channelData = channelData;
  }

  public BotData getBotUserData() {
    return botUserData;
  }

  public void setBotUserData(BotData botUserData) {
    this.botUserData = botUserData;
  }

  public BotData getBotConversationData() {
    return botConversationData;
  }

  public void setBotConversationData(BotData botConversationData) {
    this.botConversationData = botConversationData;
  }

  public BotData getBotPerUserInConversationData() {
    return botPerUserInConversationData;
  }

  public void setBotPerUserInConversationData(BotData botPerUserInConversationData) {
    this.botPerUserInConversationData = botPerUserInConversationData;
  }

  public Location getLocation() {
    return location;
  }

  public void setLocation(Location location) {
    this.location = location;
  }

  public List<String> getHashtags() {
    return hashtags;
  }

  public void setHashtags(List<String> hashtags) {
    this.hashtags = hashtags;
  }

  public String geteTag() {
    return eTag;
  }

  public void seteTag(String eTag) {
    this.eTag = eTag;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Message message = (Message) o;
    return type == message.type &&
           Objects.equals(id, message.id) &&
           Objects.equals(conversationId, message.conversationId) &&
           Objects.equals(from, message.from) &&
           Objects.equals(to, message.to);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, id, conversationId, from, to);
  }

  @Override
  public String toString() {
    return "Message{" +
           "type=" + type +
           ", id='" + id + '\'' +
           ", conversationId='" + conversationId + '\'' +
           ", created='" + created + '\'' +
           ", sourceText='" + sourceText + '\'' +
           ", sourceLanguage='" + sourceLanguage + '\'' +
           ", language='" + language + '\'' +
           ", text='" + text + '\'' +
           ", attachments=" + attachments +
           ", from=" + from +
           ", to=" + to +
           ", replyToMessageId='" + replyToMessageId + '\'' +
           ", participants=" + participants +
           ", totalParticipants=" + totalParticipants +
           ", mentions=" + mentions +
           ", place='" + place + '\'' +
           ", channelMessageId='" + channelMessageId + '\'' +
           ", channelConversationId='" + channelConversationId + '\'' +
           ", channelData=" + channelData +
           ", botUserData=" + botUserData +
           ", botConversationData=" + botConversationData +
           ", botPerUserInConversationData=" + botPerUserInConversationData +
           ", location=" + location +
           ", hashtags=" + hashtags +
           ", eTag='" + eTag + '\'' +
           '}' + super.toString();
  }

  public Message createReplyMessage() {
    Message response = new Message();
    response.setConversationId(this.getConversationId());
    response.setFrom(this.getTo());
    response.setLanguage(this.getLanguage());
    response.setTo(this.getFrom());
    return response;
  }

  public Message createReplyMessage(String text) {
    Message response = this.createReplyMessage();
    response.setText(text);
    return response;
  }
}
