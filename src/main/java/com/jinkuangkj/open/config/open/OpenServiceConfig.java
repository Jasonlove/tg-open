package com.jinkuangkj.open.config.open;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.github.binarywang.wxpay.config.WxPayConfig;
import com.github.binarywang.wxpay.service.WxPayService;
import com.github.binarywang.wxpay.service.impl.WxPayServiceImpl;

import me.chanjar.weixin.mp.api.WxMpConfigStorage;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.WxMpTemplateMsgService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.api.impl.WxMpTemplateMsgServiceImpl;

@Component
public class OpenServiceConfig {
 
    @Autowired
    private OpenConfig openConfig;
 
 
    @Bean
    public WxMpConfigStorage wxMpConfigStorage(){
        WxMpInMemoryConfigStorage wxMpConfigStorage = new WxMpInMemoryConfigStorage();
        wxMpConfigStorage.setAppId(openConfig.getMpAppId());
        wxMpConfigStorage.setSecret(openConfig.getMpAppSecret());
        wxMpConfigStorage.setTemplateId("zwQQqVpZUtqUcWanwHjawwG1gAE5nLEf5olCtlbH2o8");
        return wxMpConfigStorage;
    }
    
    @Bean
    public WxMpService wxMpService(){
    	WxMpService wxMpService = new WxMpServiceImpl();
    	wxMpService.setWxMpConfigStorage(wxMpConfigStorage());
    	return wxMpService;
    }
    
    @Bean
    public WxMpTemplateMsgService wxMpTemplateMsgService(){
    	WxMpTemplateMsgService service = new WxMpTemplateMsgServiceImpl(wxMpService());
    	return service;
    }
    
    
    @Bean
    public WxPayService getWxPayService() {
    	WxPayService wxPayService = new WxPayServiceImpl();
    	WxPayConfig  config = new WxPayConfig();
    	config.setAppId(openConfig.getMpAppId());
    	config.setMchId(openConfig.getMpMchId());
    	config.setMchKey(openConfig.getMpMchKey());
    	config.setKeyPath("classpath:cert/apiclient_cert.p12");
    	wxPayService.setConfig(config);
    	return wxPayService;
    }
    
}

