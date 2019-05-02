package com.jinkuangkj.open.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jinkuangkj.open.mapper.ActUserDao;
import com.jinkuangkj.open.mapper.ActivityDao;
import com.jinkuangkj.open.model.ActUser;
import com.jinkuangkj.open.model.Activity;
import com.jinkuangkj.open.service.ActUserService;

import me.chanjar.weixin.mp.bean.result.WxMpUser;

@Service
public class ActUserServiceImpl implements ActUserService {

	@Autowired
	private ActUserDao actUserDao;
	
	@Autowired
	private ActivityDao activityDao;
	
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

}
