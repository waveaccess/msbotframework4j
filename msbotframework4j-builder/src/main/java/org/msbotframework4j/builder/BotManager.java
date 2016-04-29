package org.msbotframework4j.builder;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.FileBasedConfiguration;
import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.FileBasedConfigurationBuilder;
import org.apache.commons.configuration2.builder.fluent.Parameters;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.apache.commons.configuration2.io.ClasspathLocationStrategy;
import org.msbotframework4j.builder.bot.Bot;
import org.msbotframework4j.builder.exception.BotConfigurationException;
import org.msbotframework4j.builder.exception.BotImplementationNotFound;
import org.msbotframework4j.builder.exception.BotInstantiationException;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author Maksim Kanev
 */
public class BotManager {

  private final Parameters params = new Parameters();

  public static BotManager getInstance() {
    return BotManagerInstanceHolder.INSTANCE;
  }

  public Bot load() {
    String botClassName = null;
    try {
      FileBasedConfigurationBuilder<FileBasedConfiguration> builder = new FileBasedConfigurationBuilder<>(PropertiesConfiguration.class);
      builder.configure(
          params.fileBased()
              .setFileName("bot.properties")
              .setLocationStrategy(new ClasspathLocationStrategy())
      );
      Configuration config = builder.getConfiguration();
      botClassName = config.getString("source");
      Class<?> clazz = Class.forName(botClassName);
      if (clazz.isInterface() || clazz.isAnnotation()) {
        throw new BotInstantiationException("Provided source class is Interface");
      }
      Constructor<?> ctor = clazz.getDeclaredConstructor();
      return (Bot) ctor.newInstance();
    } catch (ConfigurationException e) {
      throw new BotConfigurationException("Can't read Bot configuration", e);
    } catch (ClassNotFoundException e) {
      throw new BotImplementationNotFound("Can't find Bot implementation " + botClassName, e);
    } catch (NoSuchMethodException e) {
      throw new BotInstantiationException("Can't instantiate Bot without default constructor", e);
    } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
      throw new BotInstantiationException("Can't instantiate Bot", e);
    }
  }

  private static class BotManagerInstanceHolder {

    static final BotManager INSTANCE = new BotManager();
  }

}
