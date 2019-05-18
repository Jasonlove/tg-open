package com.jinkuangkj.open.service;

import java.util.List;

import com.jinkuangkj.open.model.ActUser;
import com.jinkuangkj.open.model.result.TransferResult;

public interface TransferService {
	
	void sendRed(ActUser user,Double income,Integer orderUid);
	
	List<TransferResult> getList();

}
