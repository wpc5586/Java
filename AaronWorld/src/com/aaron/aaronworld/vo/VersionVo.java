package com.aaron.aaronworld.vo;

public class VersionVo {
    
    private String iPhoneVersion = "";
    private String androidVersion = "";
    private String iPhoneUrl = "";
    private String androidUrl = "";
    private String iPhoneContent = "";
    private String androidContent = "";
    
    /**
	 * @return the iPhoneContent
	 */
	public String getiPhoneContent() {
		return iPhoneContent;
	}
	/**
	 * @param iPhoneContent the iPhoneContent to set
	 */
	public void setiPhoneContent(String iPhoneContent) {
		this.iPhoneContent = iPhoneContent;
	}
	/**
	 * @return the androidContent
	 */
	public String getAndroidContent() {
		return androidContent;
	}
	/**
	 * @param androidContent the androidContent to set
	 */
	public void setAndroidContent(String androidContent) {
		this.androidContent = androidContent;
	}
	/**
     * @return the iPhoneVersion
     */
    public String getiPhoneVersion() {
        return iPhoneVersion;
    }
    /**
     * @param iPhoneVersion the iPhoneVersion to set
     */
    public void setiPhoneVersion(String iPhoneVersion) {
        this.iPhoneVersion = iPhoneVersion;
    }
    /**
     * @return the androidVersion
     */
    public String getAndroidVersion() {
        return androidVersion;
    }
    /**
     * @param androidVersion the androidVersion to set
     */
    public void setAndroidVersion(String androidVersion) {
        this.androidVersion = androidVersion;
    }
    /**
     * @return the iPhoneUrl
     */
	public String getiPhoneUrl() {
		return iPhoneUrl;
	}
    /**
     * @param iPhoneUrl the iPhoneUrl to set
     */
	public void setiPhoneUrl(String iPhoneUrl) {
		this.iPhoneUrl = iPhoneUrl;
	}
    /**
     * @return the androidUrl
     */
	public String getAndroidUrl() {
		return androidUrl;
	}
    /**
     * @param androidUrl the androidUrl to set
     */
	public void setAndroidUrl(String androidUrl) {
		this.androidUrl = androidUrl;
	}
}
