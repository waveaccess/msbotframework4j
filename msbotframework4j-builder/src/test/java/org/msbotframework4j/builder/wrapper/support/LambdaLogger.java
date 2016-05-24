package org.msbotframework4j.builder.wrapper.support;

/**
 * @author Maksim Kanev
 */
public class LambdaLogger implements com.amazonaws.services.lambda.runtime.LambdaLogger {

  @Override
  public void log(String string) {
    System.out.println(string);
  }
}
