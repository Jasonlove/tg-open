package com.jinkuangkj.open;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.binarywang.wxpay.bean.request.WxPaySendRedpackRequest;
import com.github.binarywang.wxpay.exception.WxPayException;
import com.github.binarywang.wxpay.service.WxPayService;
import com.jinkuangkj.open.util.PrimaryGenerater;

import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpTemplateMsgService;
import me.chanjar.weixin.mp.bean.template.WxMpTemplate;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateIndustry;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateIndustry.Industry;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TgOpenApplicationTests {
	
	
	@Autowired
	private WxPayService wxPayService;
	@Autowired
	private WxMpTemplateMsgService msgService;

	@Test
	public void contextLoads() throws WxPayException {
		
		WxPaySendRedpackRequest request = WxPaySendRedpackRequest.newBuilder()
			.actName("分享")
			.mchBillNo(PrimaryGenerater.getTradeNo())
			.sendName("测试")
			.reOpenid("o7m8PwzG7svqNrNc-xEN4O2APUZo")
			.clientIp("127.0.0.1")
			.remark("分享红包")
			.wishing("你好红包")
			.totalAmount(30)
			.build();
		
		wxPayService.sendRedpack(request);
		
	}
	
	@Test
	public void msg() throws WxPayException, WxErrorException {
		
		
		
		/*
		 * WxMpTemplateIndustry wxMpIndustry = new WxMpTemplateIndustry(); Industry
		 * industry1 = new Industry(); Industry industry2 = new Industry();
		 * industry1.setId("1"); industry2.setId("4");
		 * wxMpIndustry.setPrimaryIndustry(industry1);
		 * wxMpIndustry.setSecondIndustry(industry2);
		 * 
		 * boolean b = msgService.setIndustry(wxMpIndustry);
		 */
		 
		
		/*
		 * WxMpTemplateIndustry industry = msgService.getIndustry();
		 * System.out.println(industry);
		 */
		
		List<WxMpTemplate> list = msgService.getAllPrivateTemplate();
		System.out.println(list);
		  
		  
		
	}
	

}
