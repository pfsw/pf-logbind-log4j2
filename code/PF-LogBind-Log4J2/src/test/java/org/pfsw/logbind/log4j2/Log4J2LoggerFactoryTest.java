package org.pfsw.logbind.log4j2;

import static org.junit.Assert.*;

import org.junit.Test;
import org.pfsw.logbind.log4j2.testhelper.UnitTestHelper;
import org.pfsw.logging.Logger;
import org.pfsw.logging.Logger2;
import org.pfsw.logging.LoggerFactoryProvider;

/**
 * These tests will only be successful if the following system property is set:
 * <strong>-Dorg.pfsw.logging.binding=LOG4J2</strong>
 */
public class Log4J2LoggerFactoryTest
{
  @Test
  public void test_binding__logger()
  {
    Logger logger = LoggerFactoryProvider.getLogger("test1");

    assertTrue(logger instanceof Log4J2LoggerAdapter);
    assertEquals("test1", logger.getName());
    assertFalse(logger.isLoggingDebugs());
    assertTrue(logger.isLoggingInfos());
    assertTrue(logger.isLoggingWarnings());
    assertTrue(logger.isLoggingErrors());
    logger.logInfo("Unittest <{0}>' was successful", "test_binding__logger()");
  }

  @Test
  public void test_binding__logger2()
  {
    Logger2 logger = LoggerFactoryProvider.getLogger2("test2");

    assertEquals("test2", logger.getLoggerName());
    assertFalse(logger.isDebugEnabled());
    assertFalse(logger.isInfoEnabled());
    assertTrue(logger.isWarnEnabled());
    assertTrue(logger.isErrorEnabled());
    logger.warnf("Unittest '%s' was successful", "test_binding__logger2()");
  }

  @Test
  public void test_binding__root_logger()
  {
    Logger logger = LoggerFactoryProvider.getLoggerFactory().createLogger();
    
    assertTrue(logger instanceof Log4J2LoggerAdapter);
    assertEquals("", logger.getName());
    assertFalse(logger.isLoggingDebugs());
    assertFalse(logger.isLoggingInfos());
    assertFalse(logger.isLoggingWarnings());
    assertTrue(logger.isLoggingErrors());
    logger.logError("Unittest {0} was successful", "test_binding__root_logger()");
  }
  
  @Test
  public void test_log_all_levels()
  {
    UnitTestHelper.logAllLevels();
  }
}