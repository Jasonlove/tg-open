package com.jinkuangkj.open.model.result;

public class ShareResult {
	
	/**
	 * 活动地址
	 */
	private String actUrl;
	/**
	 * 活动标题
	 */
	private String shareTitle;
    /**
     * 分享描述
     */
    private String shareDesc;
    /**
     * 分享图标 全路径
     */
    private String shareSmallImg;
	public String getShareTitle() {
		return shareTitle;
	}
	public void setShareTitle(String shareTitle) {
		this.shareTitle = shareTitle;
	}
	public String getShareDesc() {
		return shareDesc;
	}
	public void setShareDesc(String shareDesc) {
		this.shareDesc = shareDesc;
	}
	public String getShareSmallImg() {
		return shareSmallImg;
	}
	public void setShareSmallImg(String shareSmallImg) {
		this.shareSmallImg = shareSmallImg;
	}
	public String getActUrl() {
		return actUrl;
	}
	public void setActUrl(String actUrl) {
		this.actUrl = actUrl;
	}

}
