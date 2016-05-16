package org.msbotframework4j.core.model;

/**
 * Class that represents content attachments
 *
 * @author <a href="mailto:maksim.kanev@gmail.com">Maksim Kanev</a>
 */
public final class Attachment {

  /**
   * MimeType/ContentType for the file, either ContentUrl or Content must be set depending on the MimeType
   */
  private String contentType;
  /**
   * Url to content
   */
  private String contentUrl;
  /**
   * Content Payload (for example, lat/long for ContentType="location"
   */
  private Object content;
  /**
   * (OPTIONAL-CARD) FallbackText - used for downlevel clients, should be simple markup with links
   */
  private String fallbackText;
  /**
   * (OPTIONAL-CARD) Title
   */
  private String title;
  /**
   * (OPTIONAL-CARD) link to use for the title
   */
  private String titleLink;
  /**
   * (OPTIONAL-CARD) The Text description the attachment
   */
  private String text;
  /**
   * (OPTIONAL-CARD) Thumbnail associated with attachment
   */
  private String thumbnailUrl;

  public String getContentType() {
    return contentType;
  }

  public void setContentType(String contentType) {
    this.contentType = contentType;
  }

  public String getContentUrl() {
    return contentUrl;
  }

  public void setContentUrl(String contentUrl) {
    this.contentUrl = contentUrl;
  }

  public Object getContent() {
    return content;
  }

  public void setContent(Object content) {
    this.content = content;
  }

  public String getFallbackText() {
    return fallbackText;
  }

  public void setFallbackText(String fallbackText) {
    this.fallbackText = fallbackText;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getTitleLink() {
    return titleLink;
  }

  public void setTitleLink(String titleLink) {
    this.titleLink = titleLink;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public String getThumbnailUrl() {
    return thumbnailUrl;
  }

  public void setThumbnailUrl(String thumbnailUrl) {
    this.thumbnailUrl = thumbnailUrl;
  }

  @Override
  public String toString() {
    return "Attachment{" +
           "contentType='" + contentType + '\'' +
           ", contentUrl='" + contentUrl + '\'' +
           ", content=" + content +
           ", fallbackText='" + fallbackText + '\'' +
           ", title='" + title + '\'' +
           ", titleLink='" + titleLink + '\'' +
           ", text='" + text + '\'' +
           ", thumbnailUrl='" + thumbnailUrl + '\'' +
           '}';
  }
}
