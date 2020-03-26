package com.github.springbootshirodemo.common.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Component
@ConfigurationProperties(prefix="encryption")
public class ServerProperties {

    private String encryptAESKey;

    private String encryptJWTKey;
    private String accessTokenExpireTime;

    private String refreshTokenExpireTime;

    private String shiroCacheExpireTime;

    public String getEncryptAESKey() {
        return encryptAESKey;
    }

    public void setEncryptAESKey(String encryptAESKey) {
        this.encryptAESKey = encryptAESKey;
    }

    public String getEncryptJWTKey() {
        return encryptJWTKey;
    }

    public void setEncryptJWTKey(String encryptJWTKey) {
        this.encryptJWTKey = encryptJWTKey;
    }

    public String getAccessTokenExpireTime() {
        return accessTokenExpireTime;
    }

    public void setAccessTokenExpireTime(String accessTokenExpireTime) {
        this.accessTokenExpireTime = accessTokenExpireTime;
    }

    public String getRefreshTokenExpireTime() {
        return refreshTokenExpireTime;
    }

    public void setRefreshTokenExpireTime(String refreshTokenExpireTime) {
        this.refreshTokenExpireTime = refreshTokenExpireTime;
    }

    public String getShiroCacheExpireTime() {
        return shiroCacheExpireTime;
    }

    public void setShiroCacheExpireTime(String shiroCacheExpireTime) {
        this.shiroCacheExpireTime = shiroCacheExpireTime;
    }
}
