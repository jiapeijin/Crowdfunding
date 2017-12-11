package com.crowdfunding.entity.sys;

import com.crowdfunding.framework.Base.BaseEntity;

/**
 * 用户信息表
 */
public class UserInfo extends BaseEntity<UserInfo> {
    /**
     * 头像
     */
    public String imgHead;
    /**
     * 登录名
     */
    public String loginName;
    /**
     * 密码
     */
    public String password;
    /**
     * 真实姓名
     */
    public String realName;
    /**
     * 身份证
     */
    public String userCard;
    /**
     * 性别
     */
    public String userSex;
    /**
     * 简介
     */
    public String userIntroduction;
    /**
     * 用户地址
     */
    public String userAddress;
    /**
     * 教育
     */
    public String userEducation;
    /**
     * 电话1
     */
    public String phoneOne;
    /**
     * 电话2
     */
    public String phoneTwo;
    /**
     * 身份证正面
     */
    public String cardFace;
    /**
     * 身份证反面
     */
    public String cardCon;
    /**
     * 邮箱
     */
    public String email;
    /**
     * 微博
     */
    public String webo;
    /**
     * 博客
     */
    public String boke;
    /**
     * 微信
     */
    public String wechart;

    public String getImgHead() {
        return imgHead;
    }

    public void setImgHead(String imgHead) {
        this.imgHead = imgHead;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getUserCard() {
        return userCard;
    }

    public void setUserCard(String userCard) {
        this.userCard = userCard;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getUserIntroduction() {
        return userIntroduction;
    }

    public void setUserIntroduction(String userIntroduction) {
        this.userIntroduction = userIntroduction;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserEducation() {
        return userEducation;
    }

    public void setUserEducation(String userEducation) {
        this.userEducation = userEducation;
    }

    public String getPhoneOne() {
        return phoneOne;
    }

    public void setPhoneOne(String phoneOne) {
        this.phoneOne = phoneOne;
    }

    public String getPhoneTwo() {
        return phoneTwo;
    }

    public void setPhoneTwo(String phoneTwo) {
        this.phoneTwo = phoneTwo;
    }

    public String getCardFace() {
        return cardFace;
    }

    public void setCardFace(String cardFace) {
        this.cardFace = cardFace;
    }

    public String getCardCon() {
        return cardCon;
    }

    public void setCardCon(String cardCon) {
        this.cardCon = cardCon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebo() {
        return webo;
    }

    public void setWebo(String webo) {
        this.webo = webo;
    }

    public String getBoke() {
        return boke;
    }

    public void setBoke(String boke) {
        this.boke = boke;
    }

    public String getWechart() {
        return wechart;
    }

    public void setWechart(String wechart) {
        this.wechart = wechart;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                ", imgHead='" + imgHead + '\'' +
                ", loginName='" + loginName + '\'' +
                ", password='" + password + '\'' +
                ", realName='" + realName + '\'' +
                ", userCard='" + userCard + '\'' +
                ", userSex='" + userSex + '\'' +
                ", userIntroduction='" + userIntroduction + '\'' +
                ", userAddress='" + userAddress + '\'' +
                ", userEducation='" + userEducation + '\'' +
                ", phoneOne='" + phoneOne + '\'' +
                ", phoneTwo='" + phoneTwo + '\'' +
                ", cardFace='" + cardFace + '\'' +
                ", cardCon='" + cardCon + '\'' +
                ", email='" + email + '\'' +
                ", webo='" + webo + '\'' +
                ", boke='" + boke + '\'' +
                ", wechart='" + wechart + '\'' +
                '}';
    }
}
