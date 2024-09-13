package com.projects.async_logging;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AsyncLoggingApplication implements CommandLineRunner {

	private static final int oneMillion = 1000000;
    private static final Logger syncLogger = LogManager.getLogger("SyncLogger");
    private static final Logger asyncLogger = LogManager.getLogger(AsyncLoggingApplication.class);


    public static void main(String[] args) {
        SpringApplication.run(AsyncLoggingApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

		// Synchronous
		long syncLoggingStartTime = System.currentTimeMillis();
		syncLoggers();
		long syncEndTime = System.currentTimeMillis();

		// Asynchronous
		long asyncLoggingStartTime = System.currentTimeMillis();
		asyncLoggers();
		long asyncEndTime = System.currentTimeMillis();

		System.out.println(String.format("Sync Logging Time: (%s, %s)", syncLoggingStartTime, syncEndTime));
		System.out.println(String.format("Async Logging Time: (%s, %s)", asyncLoggingStartTime, asyncEndTime));
    }

    private static void syncLoggers() {
        for (int i = 0; i < oneMillion; i++) {
			syncLogger.info("Value is " + i);
        }
    }

	private static void asyncLoggers() {
        for (int i = 0; i < oneMillion; i++) {
			asyncLogger.info("Value is " + i);
        }
    }
}
