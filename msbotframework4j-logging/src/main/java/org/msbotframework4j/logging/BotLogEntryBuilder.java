package org.msbotframework4j.logging;

import org.apache.commons.lang3.text.StrBuilder;

/**
 * Builder for {@link BotLogEntry}
 *
 * @author Maksim Kanev
 */
public interface BotLogEntryBuilder {

  /**
   * Appends a whitespace character to this builder.
   *
   * @return {@code this}, to enable chaining
   * @see #appendSeparator(char)
   */
  BotLogEntryBuilder appendWhitespaceSeparator();

  /**
   * Appends a separator if the builder is currently non-empty.
   *
   * @param separator the separator to use
   * @return {@code this}, to enable chaining
   * @see StrBuilder#appendSeparator(char)
   */
  BotLogEntryBuilder appendSeparator(char separator);

  /**
   * Appends an object to this builder.
   *
   * @param obj the object to append
   * @return {@code this}, to enable chaining
   * @see StrBuilder#append(Object)
   */
  BotLogEntryBuilder append(Object obj);

  /**
   * Appends a string to this builder.
   *
   * @param str the string to append
   * @return {@code this}, to enable chaining
   * @see StrBuilder#append(String)
   */
  BotLogEntryBuilder append(String str);

  /**
   * Calls {@link String#format(String, Object...)} and appends the result
   *
   * @param format the format string
   * @param objs   the objects to use in the format string
   * @return {@code this}, to enable chaining
   * @see StrBuilder#append(String, Object...)
   */
  BotLogEntryBuilder append(String format, Object... objs);

  /**
   * Appends the new line string to this builder.
   *
   * @return {@code this}, to enable chaining
   * @see StrBuilder#appendNewLine()
   */
  BotLogEntryBuilder appendNewLine();

  /**
   * Appends an int value to this builder.
   *
   * @param value the value to append
   * @return {@code this}, to enable chaining
   * @see StrBuilder#append(int)
   */
  BotLogEntryBuilder append(int value);

  /**
   * Appends a long value to the builder
   *
   * @param value the value to append
   * @return {@code this}, to enable chaining
   * @see StrBuilder#append(long)
   */
  BotLogEntryBuilder append(long value);

  /**
   * Appends a float value to the builder
   *
   * @param value the value to append
   * @return {@code this}, to enable chaining
   * @see StrBuilder#append(float)
   */
  BotLogEntryBuilder append(float value);

  /**
   * Appends a double value to the builder
   *
   * @param value the value to append
   * @return {@code this}, to enable chaining
   * @see StrBuilder#append(double)
   */
  BotLogEntryBuilder append(double value);

  /**
   * Appends a boolean value to the builder
   *
   * @param value the value to append
   * @return {@code this}, to enable chaining
   * @see StrBuilder#append(boolean)
   */
  BotLogEntryBuilder append(boolean value);

  /**
   * Appends a char value to the builder
   *
   * @param ch the value to append
   * @return {@code this}, to enable chaining
   * @see StrBuilder#append(char)
   */
  BotLogEntryBuilder append(char ch);

  /**
   * Appends an object followed by a new line to this builder
   *
   * @param obj the object to append
   * @return {@code this}, to enable chaining
   * @see StrBuilder#appendln(Object)
   */
  BotLogEntryBuilder appendln(Object obj);

  /**
   * Appends a string followed by a new line to this builder
   *
   * @param str the string to append
   * @return {@code this}, to enable chaining
   * @see StrBuilder#appendln(String)
   */
  BotLogEntryBuilder appendln(String str);

  /**
   * Calls {@link String#format(String, Object...)} and appends the result followed by a new line to this builder.
   *
   * @param format the format string
   * @param objs   the objects to use in the format string
   * @return {@code this}, to enable chaining
   * @see StrBuilder#appendln(String, Object...)
   */
  BotLogEntryBuilder appendln(String format, Object... objs);

  /**
   * Appends a boolean value followed by a new line to the builder.
   *
   * @param value the value to append
   * @return {@code this}, to enable chaining
   * @see StrBuilder#appendln(boolean)
   */
  BotLogEntryBuilder appendln(boolean value);

  /**
   * Appends a char value followed by a new line to the builder.
   *
   * @param ch the value to append
   * @return {@code this}, to enable chaining
   * @see StrBuilder#appendln(char)
   */
  BotLogEntryBuilder appendln(char ch);

  /**
   * Appends an int value followed by a new line to the builder.
   *
   * @param value the value to append
   * @return {@code this}, to enable chaining
   * @see StrBuilder#appendln(int)
   */
  BotLogEntryBuilder appendln(int value);

  /**
   * Appends a long value followed by a new line to the builder.
   *
   * @param value the value to append
   * @return {@code this}, to enable chaining
   * @see StrBuilder#appendln(long)
   */
  BotLogEntryBuilder appendln(long value);

  /**
   * Appends a float value followed by a new line to the builder.
   *
   * @param value the value to append
   * @return {@code this}, to enable chaining
   * @see StrBuilder#appendln(float)
   */
  BotLogEntryBuilder appendln(float value);

  /**
   * Appends a double value followed by a new line to the builder.
   *
   * @param value the value to append
   * @return {@code this}, to enable chaining
   * @see StrBuilder#appendln(double)
   */
  BotLogEntryBuilder appendln(double value);

  /**
   * Appends the pad character to the builder the specified number of times.
   *
   * @param length  the length to append, negative means no append
   * @param padChar the character to append
   * @return {@code this}, to enable chaining
   * @see StrBuilder#appendPadding(int, char)
   */
  BotLogEntryBuilder appendPadding(int length, char padChar);

  /**
   * Appends an object to the builder padding on the left to a fixed width.
   *
   * @param obj     the object to append, null uses null text
   * @param width   the fixed field width, zero or negative has no effect
   * @param padChar the pad character to use
   * @return {@code this}, to enable chaining
   * @see StrBuilder#appendFixedWidthPadLeft(Object, int, char)
   */
  BotLogEntryBuilder appendFixedWidthPadLeft(Object obj, int width, char padChar);

  /**
   * Appends an object to the builder padding on the right to a fixed length.
   *
   * @param obj     the object to append, null uses null text
   * @param width   the fixed field width, zero or negative has no effect
   * @param padChar the pad character to use
   * @return {@code this}, to enable chaining
   * @see StrBuilder#appendFixedWidthPadRight(Object, int, char)
   */
  BotLogEntryBuilder appendFixedWidthPadRight(Object obj, int width, char padChar);

  /**
   * Trims the builder by removing characters less than or equal to a space from the beginning and end.
   *
   * @return {@code this}, to enable chaining
   * @see StrBuilder#trim()
   */
  BotLogEntryBuilder trim();

  /**
   * Sets the severity level using {@link BotLogEntry#setSeverity(BotLogSeverity)}
   *
   * @param severity the severity level of {@link BotLogEntry}
   * @return {@code this}, to enable chaining
   */
  BotLogEntryBuilder withSeverity(BotLogSeverity severity);

  /**
   * Sets the exception that would be accompanied with this message
   *
   * @param exception the {@link Exception} which would be accompanied with this message
   * @return {@code this}, to enable chaining
   */
  BotLogEntryBuilder withException(Throwable exception);

  /**
   * Calls {@link BotLogger#log(BotLogEntry)} to write message to a logging stream
   */
  void push();
}
