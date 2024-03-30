package com.experiments;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.encrypt.BytesEncryptor;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.security.crypto.keygen.KeyGenerators;

import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Slf4j
class SpringSecurityCryptoModuleApplicationTests {

    private static String password;
    private static String salt;

    @BeforeAll
    static void setup() {
        password = "@SpringSecurityCryptoModule01";
        salt = KeyGenerators.string().generateKey();
    }

    @Test
    @DisplayName("Bytes Encryptor")
    void givenTextToEncryptAndDecrypt_whenEncryptTextBytesEncryptor_thenReturnDecryptedTextBytesEncryptor() {

        /**
         * stronger function used AES-256 with GCM
         * It also requires the use of Java 6 and above
         * The password should be kept in a secure place and should not be shared
         * The salt is used to prevent dictionary attacks (salt = hex-encoded string)
         */

        // given
        String text = "Text to encrypt and decrypt";
        BytesEncryptor bytesEncryptor = Encryptors.stronger(password, salt);

        // when
        byte[] encryptedText = bytesEncryptor.encrypt(text.getBytes());
        byte[] decryptedText = bytesEncryptor.decrypt(encryptedText);

        log.info("Original Text: {}", text);
        log.info("Encrypted Text: {}", new String(encryptedText, StandardCharsets.UTF_8));
        log.info("Decrypted Text: {}", new String(decryptedText, StandardCharsets.UTF_8));

        // then
        assertEquals(text, new String(decryptedText, StandardCharsets.UTF_8));
    }

    @Test
    @DisplayName("Text Encryptor")
    void givenTextToEncryptAndDecrypt_whenEncryptTextTextEncryptor_thenReturnDecryptedTextTextEncryptor() {

        /**
         * Text encryptor uses standard BytesEncryptor to encrypt text data
         * Encrypted data returned as hex-encoded strings for easy storage in a database
         * Typically, the key must be stored in the databased together with the encrypted text
         */

        // given
        String text = "Text to encrypt and decrypt";
        TextEncryptor textEncryptor = Encryptors.text(password, salt);

        // when
        String encryptedText = textEncryptor.encrypt(text);
        String decryptedText = textEncryptor.decrypt(encryptedText);

        log.info("Original Text: {}", text);
        log.info("Encrypted Text: {}", encryptedText);
        log.info("Decrypted Text: {}", decryptedText);

        // then
        assertEquals(text, decryptedText);
    }
}
