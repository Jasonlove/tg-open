package com.jinkuangkj.open.config.open;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Component
@ConfigurationProperties(prefix="wechat")
public class OpenConfig {
 
	//应用appid
    private String mpAppId;
    //密钥
    private String mpAppSecret;
    
    private String mpBaseUrl;
    //商户号
    private String mpMchId;
    //key
    private String mpMchKey;

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

	public String getMpBaseUrl() {
		return mpBaseUrl;
	}

	public void setMpBaseUrl(String mpBaseUrl) {
		this.mpBaseUrl = mpBaseUrl;
	}

	public String getMpMchId() {
		return mpMchId;
	}

	public void setMpMchId(String mpMchId) {
		this.mpMchId = mpMchId;
	}

	public String getMpMchKey() {
		return mpMchKey;
	}

	public void setMpMchKey(String mpMchKey) {
		this.mpMchKey = mpMchKey;
	}
    
 
}
