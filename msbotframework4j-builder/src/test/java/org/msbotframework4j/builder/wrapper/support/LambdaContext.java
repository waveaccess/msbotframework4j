package org.msbotframework4j.builder.wrapper.support;

import com.amazonaws.services.lambda.runtime.ClientContext;
import com.amazonaws.services.lambda.runtime.CognitoIdentity;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;

import org.apache.commons.lang3.RandomUtils;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author <a href="mailto:maksim.kanev@gmail.com">Maksim Kanev</a>
 */
public class LambdaContext implements Context {

  @Override
  public String getAwsRequestId() {
    return UUID.randomUUID().toString();
  }

  @Override
  public String getLogGroupName() {
    return "test-log-group-name";
  }

  @Override
  public String getLogStreamName() {
    return "test-log-stream-name";
  }

  @Override
  public String getFunctionName() {
    return "test-function-name";
  }

  @Override
  public String getFunctionVersion() {
    return "test-function-version";
  }

  @Override
  public String getInvokedFunctionArn() {
    return "arn:aws:lambda:us-west-2:" + RandomUtils.nextLong(100000000000L, 999999999999L) + ":function:" + getFunctionName();
  }

  @Override
  public CognitoIdentity getIdentity() {
    return null;
  }

  @Override
  public ClientContext getClientContext() {
    return null;
  }

  @Override
  public int getRemainingTimeInMillis() {
    return (int) TimeUnit.MINUTES.toMillis(15);
  }

  @Override
  public int getMemoryLimitInMB() {
    return 512;
  }

  @Override
  public LambdaLogger getLogger() {
    return new org.msbotframework4j.builder.wrapper.support.LambdaLogger();
  }
}
