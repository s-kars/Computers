package com.skars.computers.util.logging;

import org.apache.log4j.Logger;

/**
 * Utility for log4j logger.
 * 
 * @author skars
 * @version $Rev: $
 */
public class Log4jUtil {

	/**
	 * Log messages from DEBUG level.
	 * 
	 * @param log4jLogger Logj4 logger.
	 * @param message Message to log.
	 */
	public static void debug(Logger log4jLogger, String message) {
		if (log4jLogger.isDebugEnabled()) {
			log4jLogger.debug(message);
		}
	}

	/**
	 * Log messages from DEBUG level.
	 * 
	 * @param log4jLogger Logj4 logger.
	 * @param message Message to log.
	 * @param e Exception to log.
	 * @version 1
	 */
	public static void debug(Logger log4jLogger, String message, Throwable e) {
		if (log4jLogger.isDebugEnabled()) {
			log4jLogger.debug(message, e);
		}
	}
}
