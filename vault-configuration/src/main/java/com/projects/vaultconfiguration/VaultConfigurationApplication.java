package com.projects.vaultconfiguration;

import com.projects.vaultconfiguration.config.VaultConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(VaultConfig.class)
public class VaultConfigurationApplication implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(VaultConfigurationApplication.class);
	private final VaultConfig vaultConfig;

	public VaultConfigurationApplication(VaultConfig vaultConfig) {
		this.vaultConfig = vaultConfig;
	}

	public static void main(String[] args) {
		SpringApplication.run(VaultConfigurationApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("----------------------------------");
		logger.info("Configuration properties");
		logger.info(" example.username is {}", vaultConfig.getUsername());
		logger.info(" example.password is {}", vaultConfig.getPassword());
		logger.info("----------------------------------");
	}
}
