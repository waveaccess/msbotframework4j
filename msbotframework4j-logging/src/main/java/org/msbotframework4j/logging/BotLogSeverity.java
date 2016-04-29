package org.msbotframework4j.logging;

/**
 * Severity levels for Bot logging system
 *
 * @author <a href="mailto:maksim.kanev@gmail.com">Maksim Kanev</a>
 */
public enum BotLogSeverity {
  DEBUG("DBUG"), //
  INFO("INFO"), //
  WARNING("WARN"), //
  ERROR("ERRO"), //
  ;

  /**
   * Logger level abbreviation that would be used in log record
   */
  private final String abbreviation;

  BotLogSeverity(String abbreviation) {
    this.abbreviation = abbreviation;
  }

  public String getAbbreviation() {
    return abbreviation;
  }
}
