package com.aaron.aaronworld.dao.entity;

import java.util.Date;

public class ConfigEntity {
    private Integer configId;

    private String configCode;

    private String configCategory;

    private String configName;

    private String configValue;

    private String configValue1;

    private String configValue2;

    private String configValue3;

    private String configValue4;

    private String configValue5;

    private String createUser;

    private Date createDate;

    private String uploadUser;

    private Date updateDate;

    private String isUsable;

    private String remark;

    public Integer getConfigId() {
        return configId;
    }

    public void setConfigId(Integer configId) {
        this.configId = configId;
    }

    public String getConfigCode() {
        return configCode;
    }

    public void setConfigCode(String configCode) {
        this.configCode = configCode == null ? null : configCode.trim();
    }

    public String getConfigCategory() {
        return configCategory;
    }

    public void setConfigCategory(String configCategory) {
        this.configCategory = configCategory == null ? null : configCategory.trim();
    }

    public String getConfigName() {
        return configName;
    }

    public void setConfigName(String configName) {
        this.configName = configName == null ? null : configName.trim();
    }

    public String getConfigValue() {
        return configValue;
    }

    public void setConfigValue(String configValue) {
        this.configValue = configValue == null ? null : configValue.trim();
    }

    public String getConfigValue1() {
        return configValue1;
    }

    public void setConfigValue1(String configValue1) {
        this.configValue1 = configValue1 == null ? null : configValue1.trim();
    }

    public String getConfigValue2() {
        return configValue2;
    }

    public void setConfigValue2(String configValue2) {
        this.configValue2 = configValue2 == null ? null : configValue2.trim();
    }

    public String getConfigValue3() {
        return configValue3;
    }

    public void setConfigValue3(String configValue3) {
        this.configValue3 = configValue3 == null ? null : configValue3.trim();
    }

    public String getConfigValue4() {
        return configValue4;
    }

    public void setConfigValue4(String configValue4) {
        this.configValue4 = configValue4 == null ? null : configValue4.trim();
    }

    public String getConfigValue5() {
        return configValue5;
    }

    public void setConfigValue5(String configValue5) {
        this.configValue5 = configValue5 == null ? null : configValue5.trim();
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getUploadUser() {
        return uploadUser;
    }

    public void setUploadUser(String uploadUser) {
        this.uploadUser = uploadUser == null ? null : uploadUser.trim();
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getIsUsable() {
        return isUsable;
    }

    public void setIsUsable(String isUsable) {
        this.isUsable = isUsable == null ? null : isUsable.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}