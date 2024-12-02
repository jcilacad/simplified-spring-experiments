package com.projects.accessingvault;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.vault.core.*;
import org.springframework.vault.support.VaultMount;
import org.springframework.vault.support.VaultResponse;

@SpringBootApplication
public class AccessingVaultApplication implements CommandLineRunner {

	private final Logger logger = LoggerFactory.getLogger(AccessingVaultApplication.class);

	@Autowired
	private VaultTemplate vaultTemplate;

	public static void main(String[] args) {
		SpringApplication.run(AccessingVaultApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		VaultResponse response = vaultTemplate
				.opsForKeyValue("secret", VaultKeyValueOperationsSupport.KeyValueBackend.KV_2).get("github");

		logger.info("Value of github.oauth2.key: {}", response.getData().get("github.oauth2.key"));

		// Let's encrypt some data using the Transit backend.
		VaultTransitOperations transformOperations = vaultTemplate.opsForTransit();

		// We need to setup transit first (assuming you didn't set up it yet).
		VaultSysOperations sysOperations = vaultTemplate.opsForSys();

		if (!sysOperations.getMounts().containsKey("transit/")) {
			sysOperations.mount("transit", VaultMount.create("transit"));
			transformOperations.createKey("foo-key");
		}

		// Encrypt the plain-text value
		String ciphertext = transformOperations.encrypt("foo-key", "Secure message");
		logger.info("Encrypted value: {}", ciphertext);

		String plainText = transformOperations.decrypt("foo-key", ciphertext);
		logger.info("Decrypted value: {}", plainText);
	}
}
