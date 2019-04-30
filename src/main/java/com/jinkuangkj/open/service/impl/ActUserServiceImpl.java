package com.jinkuangkj.open.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.jinkuangkj.open.mapper.ActUserDao;
import com.jinkuangkj.open.model.ActUser;
import com.jinkuangkj.open.service.ActUserService;

import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.WxMpUserService;
import me.chanjar.weixin.mp.api.impl.WxMpUserServiceImpl;
import me.chanjar.weixin.mp.bean.result.WxMpUser;

public class ActUserServiceImpl implements ActUserService {

	@Autowired
	private ActUserDao actUserDao;
	
	@Autowired
    private WxMpService wxMpService;
	
	@Override
	public ActUser register(Integer actId, String openId,String shareId) {
		
		//进入活动页面
		
		ActUser actUser = actUserDao.selectByOpenId(openId);
		if(null != actUser) {
			return actUser;
		}
    	try {
    		WxMpUserService service = new WxMpUserServiceImpl(wxMpService);
			WxMpUser info = service.userInfo(openId);
			actUser = new ActUser();
			actUser.setActId(Integer.valueOf(actId));
			actUser.setHeadimgurl(info.getHeadImgUrl());
			actUser.setOpenid(info.getOpenId());
			actUser.setNickname(info.getNickname());
			actUser.setShareUserId(Integer.valueOf(shareId));
			actUserDao.insert(actUser);
			
		} catch (WxErrorException e) {
			e.printStackTrace();
		}
		return actUser;
	}

	

}
