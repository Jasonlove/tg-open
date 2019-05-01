package com.jinkuangkj.open;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.binarywang.wxpay.bean.request.WxPaySendRedpackRequest;
import com.github.binarywang.wxpay.exception.WxPayException;
import com.github.binarywang.wxpay.service.WxPayService;
import com.jinkuangkj.open.util.PrimaryGenerater;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TgOpenApplicationTests {
	
	
	@Autowired
	private WxPayService wxPayService;

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
	

}
