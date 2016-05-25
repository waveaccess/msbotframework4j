package org.msbotframework4j.builder.wrapper.support;

/**
 * @author <a href="mailto:maksim.kanev@gmail.com">Maksim Kanev</a>
 */
public class LambdaLogger implements com.amazonaws.services.lambda.runtime.LambdaLogger {

  @Override
  public void log(String string) {
    System.out.println(string);
  }
}
