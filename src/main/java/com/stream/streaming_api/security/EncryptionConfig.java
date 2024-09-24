package com.stream.streaming_api.security;

import lombok.extern.log4j.Log4j2;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.iv.RandomIvGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
@Log4j2
public class EncryptionConfig {

    PooledPBEStringEncryptor encryptor;

    @Autowired
    public EncryptionConfig() {
        encryptor = new PooledPBEStringEncryptor();
//        encryptor.setPassword(System.getProperty("jasypt.encryptor.password"));
        encryptor.setPassword("unapasswordlosuficientemenetelargaparaencriptar");
        encryptor.setAlgorithm("PBEWithHMACSHA512AndAES_256");
        encryptor.setIvGenerator(new RandomIvGenerator());
        encryptor.setKeyObtentionIterations(100);
    }

    public String encrypt(String plainText) {
        return encryptor.encrypt(plainText);
    }

    public String decrypt(String encryptedText) {
        return encryptor.decrypt(encryptedText);
    }

}
