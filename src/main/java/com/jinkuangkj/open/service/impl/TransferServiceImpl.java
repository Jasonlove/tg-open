package com.jinkuangkj.open.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jinkuangkj.open.config.open.OpenConfig;
import com.jinkuangkj.open.constant.OrderStatus;
import com.jinkuangkj.open.mapper.ActUserDao;
import com.jinkuangkj.open.mapper.TransferDao;
import com.jinkuangkj.open.model.ActUser;
import com.jinkuangkj.open.model.Transfer;
import com.jinkuangkj.open.model.result.MessageResult;
import com.jinkuangkj.open.model.result.TransferResult;
import com.jinkuangkj.open.service.TransferService;
import com.jinkuangkj.open.util.PrimaryGenerater;

@Service
public class TransferServiceImpl implements TransferService{

	@Autowired
	TransferDao transferDao;
	@Autowired
	private OpenConfig openConfig;
	@Autowired
	ActUserDao actUserDao;
	
	@Override
	public void sendRed(ActUser user,Double income,Integer orderUid) {
		
		//调用三方发红包接口
		
		//添加插入记录
		Transfer transfer = new Transfer();
		transfer.setUserId(user.getId());
		transfer.setActId(user.getActId());
		transfer.setOrderUid(orderUid);
		transfer.setCreateTime(new Date());
		transfer.setAmount(income);
		transfer.setStatus(OrderStatus.PENDING.getValue());
		transfer.setTransferNo(PrimaryGenerater.getTradeNo());
		transfer.setMerchantId(openConfig.getMpMchId());
		transferDao.insertSelective(transfer);
	}

	@Override
	public List<TransferResult> getList() {
		return transferDao.getList(null);
	}

	@Override
	public MessageResult getMessage(Integer actId) {
		
		Transfer transfer = transferDao.findTransferLimit(actId);
		
		ActUser orderUser = actUserDao.selectById(transfer.getOrderUid());
		
		ActUser shareUser = actUserDao.selectById(transfer.getUserId());
		
		MessageResult result = new MessageResult();
		
		if(orderUser != null) {
			result.setOrderUser(orderUser.getNickname());
		}
		
		if(shareUser != null) {
			result.setShareUser(shareUser.getNickname());
		}
		
		if(transfer != null) {
			result.setAmount(transfer.getAmount());
		}
		
		return result;
	}

}
