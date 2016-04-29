package org.msbotframework4j.core.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Class that represents the Location facet groups geographic location-related data on OneDrive
 *
 * @author <a href="mailto:maksim.kanev@gmail.com">Maksim Kanev</a>
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public final class Location {

  /**
   * The altitude (height), in feet, above sea level for the item
   */
  private Double altitude;
  /**
   * The latitude, in decimal, for the item
   */
  private Double latitude;
  /**
   * The longitude, in decimal, for the item
   */
  private Double longitude;
  /**
   * Name for user location when the message was created
   */
  private String name;

  public Double getAltitude() {
    return altitude;
  }

  public void setAltitude(Double altitude) {
    this.altitude = altitude;
  }

  public Double getLatitude() {
    return latitude;
  }

  public void setLatitude(Double latitude) {
    this.latitude = latitude;
  }

  public Double getLongitude() {
    return longitude;
  }

  public void setLongitude(Double longitude) {
    this.longitude = longitude;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
