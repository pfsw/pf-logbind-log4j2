// ===========================================================================
// CONTENT  : CLASS Log4J2LoggerFactory
// AUTHOR   : Manfred Duchrow
// VERSION  : 1.0 - 16/05/2020
// HISTORY  :
//  16/05/2020  mdu  CREATED
//
// Copyright (c) 2020, by MDCS. All rights reserved.
// ===========================================================================
package org.pfsw.logbind.log4j2;

import org.pfsw.logging.Logger;
import org.pfsw.logging.LoggerFactory;

/**
 * This factory can be registered with the PF logging framework to support
 * binding of all PF logging output to Log4J2 loggers.
 * <p>
 * In order to activate the binding, this library must be on the classpath
 * and system property <strong>org.pfsw.logging.binding=LOG4J2</strong> set.  
 *
 * @author Manfred Duchrow
 * @version 1.0
 */
public class Log4J2LoggerFactory implements LoggerFactory
{
  public Log4J2LoggerFactory()
  {
    super();
  }

  @Override
  public String getName()
  {
    return "LOG4J2";
  }

  @Override
  public Logger createLogger()
  {
    return getLogger("");
  }

  @Override
  public Logger getLogger(Class<?> clazz)
  {
    return new Log4J2LoggerAdapter(clazz);
  }

  @Override
  public Logger getLogger(String loggerName)
  {
    return new Log4J2LoggerAdapter(loggerName);
  }
}
