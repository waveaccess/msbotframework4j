package org.msbotframework4j.core.common;

/**
 * Interfaces for common constants
 *
 * @author <a href="mailto:maksim.kanev@gmail.com">Maksim Kanev</a>
 */
public interface Const {

  /**
   * Environment variable name for BotFramework App ID
   */
  String ENV_KEY_APP_ID = "BOT_PORTAL_APP_ID";
  /**
   * Environment variable name for BotFramework App Secret
   */
  String ENV_KEY_APP_SECRET = "BOT_PORTAL_APP_SECRET";
  /**
   * Header name for BotFramework API auth
   */
  String REST_AUTH_HEADER = "Ocp-Apim-Subscription-Key";
}
