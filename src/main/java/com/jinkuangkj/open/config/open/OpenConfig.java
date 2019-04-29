package com.jinkuangkj.open.config.open;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Component
@ConfigurationProperties(prefix="wechat")
public class OpenConfig {
 
    private String mpAppId;
 
    private String mpAppSecret;

	public String getMpAppId() {
		return mpAppId;
	}

	public void setMpAppId(String mpAppId) {
		this.mpAppId = mpAppId;
	}

	public String getMpAppSecret() {
		return mpAppSecret;
	}

	public void setMpAppSecret(String mpAppSecret) {
		this.mpAppSecret = mpAppSecret;
	}
    
    
    
 
}
