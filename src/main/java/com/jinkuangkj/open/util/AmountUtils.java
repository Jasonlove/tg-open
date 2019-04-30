package com.jinkuangkj.open.util;

import java.math.BigDecimal;

public class AmountUtils {
	
	
	public static BigDecimal getStorageAmount(Integer amount) {

        if(amount == null) { return null; }

        String moneyString = String.valueOf(amount);

        BigDecimal decimalAmount = new BigDecimal(moneyString);

        BigDecimal oneHundred = new BigDecimal("0.01");

        return decimalAmount.multiply(oneHundred);
    }

    /**
     * <p>获取支付金额，数据库存储的原始金额乘以100</p>
     *
     * @param amount 存储金额
     * @return 支付金额
     */
    public static Integer getPayAmount(Double amounts) {
    	
    	BigDecimal amount = new BigDecimal(amounts);

        BigDecimal oneHundred = new BigDecimal("100");

        return amount.multiply(oneHundred).intValue();
    }


}
