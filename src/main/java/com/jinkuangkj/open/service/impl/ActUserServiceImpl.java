package com.jinkuangkj.open.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jinkuangkj.open.mapper.ActUserDao;
import com.jinkuangkj.open.mapper.ActivityDao;
import com.jinkuangkj.open.model.ActUser;
import com.jinkuangkj.open.model.Activity;
import com.jinkuangkj.open.service.ActUserService;
import com.jinkuangkj.open.service.TransferService;

import me.chanjar.weixin.mp.bean.result.WxMpUser;

@Service
public class ActUserServiceImpl implements ActUserService {

	@Autowired
	private ActUserDao actUserDao;
	@Autowired
	private ActivityDao activityDao;
	@Autowired
	TransferService transferService;
	
	@Override
	public ActUser register(WxMpUser info,Integer actId,String shareId) {
		
		//进入活动页面
		ActUser actUser = actUserDao.selectByOpenId(info.getOpenId());
		if(null != actUser) {
			return actUser;
		}
		actUser = new ActUser();
		actUser.setActId(Integer.valueOf(actId));
		actUser.setHeadimgurl(info.getHeadImgUrl());
		actUser.setOpenid(info.getOpenId());
		actUser.setNickname(info.getNickname());
		if(StringUtils.isNotBlank(shareId)) {
			actUser.setShareUserId(Integer.valueOf(shareId));
		}
		actUserDao.insertSelective(actUser);
		
		//活动参与人数加1
		Activity activity = activityDao.selectById(Integer.valueOf(actId));
		Integer count = activity.getJoinCount() + 1;
		activity.setJoinCount(count);
		activityDao.updateSelective(activity);
			

		return actUser;
	}

	@Override
	public List<ActUser> getList(Integer actId) {
		return actUserDao.getListByActId(actId);
	}
	
	
	public ActUser getUserById(Integer id) {
		return actUserDao.selectById(id);
	}

	@Override
	public List<ActUser> getListRanking() {
		return actUserDao.getListRanking();
	}

	@Override
	public void addIncome(Integer userId,Double income) {
		//受益人
		ActUser user = actUserDao.selectById(userId);
	    BigDecimal b1=new BigDecimal(Double.toString(user.getShareIncome()));
	    BigDecimal b2 = new BigDecimal(Double.toString(income));
	    BigDecimal add = b1.add(b2);
	    user.setShareIncome(add.doubleValue());
	    
	    Integer count = user.getShareCount() + 1;
	    user.setShareCount(count);
	    actUserDao.updateSelective(user);
	    //添加发红包记录
	    transferService.sendRed(user, income);
	}

}
