// ===========================================================================
// CONTENT  : CLASS Log4J2LoggerAdapter
// AUTHOR   : Manfred Duchrow
// VERSION  : 1.0 - 16/05/2020
// HISTORY  :
//  16/05/2020  mdu  CREATED
//
// Copyright (c) 2020, by MDCS. All rights reserved.
// ===========================================================================
package org.pfsw.logbind.log4j2;

import java.text.MessageFormat;
import java.util.Properties;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * This adapter implements the PF {@link org.pfsw.logging.Logger} interface
 * and routes all logging to a Log4J2 logger. 
 *
 * @author Manfred Duchrow
 * @version 1.0
 */
public class Log4J2LoggerAdapter implements org.pfsw.logging.Logger
{
  private final Logger delegateLogger;

  public Log4J2LoggerAdapter(String loggerName)
  {
    super();
    this.delegateLogger = LogManager.getLogger(loggerName);
  }

  public Log4J2LoggerAdapter(Class<?> clazz)
  {
    super();
    this.delegateLogger = LogManager.getLogger(clazz);
  }

  @Override
  public String getName()
  {
    return getDelegateLogger().getName();
  }

  @Override
  public void logException(Throwable ex)
  {
    getDelegateLogger().log(Level.ALL, "Exception: ", ex);
  }

  @Override
  public void logDebug(String message, Object... params)
  {
    if (isLoggingDebugs())
    {
      getDelegateLogger().debug(getLogMessage(message, params));
    }
  }

  @Override
  public void logInfo(String message, Object... params)
  {
    if (isLoggingInfos())
    {
      getDelegateLogger().info(getLogMessage(message, params));
    }
  }

  @Override
  public void logWarning(String message, Object... params)
  {
    if (isLoggingWarnings())
    {
      getDelegateLogger().warn(getLogMessage(message, params));
    }
  }

  @Override
  public void logError(String message, Object... params)
  {
    if (isLoggingErrors())
    {
      getDelegateLogger().error(getLogMessage(message, params));
    }
  }

  @Override
  public void logWarning(String message, Throwable exception)
  {
    getDelegateLogger().warn(message, exception);
  }

  @Override
  public void logError(String message, Throwable exception)
  {
    getDelegateLogger().error(message, exception);
  }

  @Override
  public boolean isLoggingDebugs()
  {
    return getDelegateLogger().isDebugEnabled();
  }

  @Override
  public boolean isLoggingInfos()
  {
    return getDelegateLogger().isInfoEnabled();
  }

  @Override
  public boolean isLoggingWarnings()
  {
    return getDelegateLogger().isWarnEnabled();
  }

  @Override
  public boolean isLoggingErrors()
  {
    return getDelegateLogger().isErrorEnabled();
  }

  @Override
  public void initialize(Properties properties)
  {
    // not supported 
  }

  @Override
  public boolean setLogLevel(String level)
  {
    // Not supported with Log4J logger
    return false;
  }

  protected String getLogMessage(String text, Object... params)
  {
    if ((params.length > 0) && (text.indexOf("{0") >= 0))
    {
      return MessageFormat.format(text, params);
    }
    return text;
  }

  protected Logger getDelegateLogger()
  {
    return this.delegateLogger;
  }
}
