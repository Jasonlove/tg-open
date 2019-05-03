package com.jinkuangkj.open.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jinkuangkj.open.config.open.OpenConfig;
import com.jinkuangkj.open.constant.OrderStatus;
import com.jinkuangkj.open.mapper.TransferDao;
import com.jinkuangkj.open.model.ActUser;
import com.jinkuangkj.open.model.Transfer;
import com.jinkuangkj.open.service.TransferService;
import com.jinkuangkj.open.util.PrimaryGenerater;

@Service
public class TransferServiceImpl implements TransferService{

	@Autowired
	TransferDao transferDao;
	@Autowired
	private OpenConfig openConfig;
	
	@Override
	public void sendRed(ActUser user,Double income) {
		
		//调用三方发红包接口
		
		//添加插入记录
		Transfer transfer = new Transfer();
		transfer.setUserId(user.getId());
		transfer.setCreateTime(new Date());
		transfer.setAmount(income);
		transfer.setStatus(OrderStatus.PENDING.getValue());
		transfer.setTransferNo(PrimaryGenerater.getTradeNo());
		transfer.setMerchantId(openConfig.getMpMchId());
		transferDao.insertSelective(transfer);
	}

	@Override
	public List<Transfer> getList() {
		return transferDao.getList();
	}

}
