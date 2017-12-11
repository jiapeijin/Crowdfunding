package com.crowdfunding.framework.Base;

import java.util.Date;

/**
 * 通用对象属性
 * Created by lucy on 2017/12/11.
 */
public class BaseEntity<T> implements java.io.Serializable {
    /**
     * id
     */
    protected String id;

    /**
     * 创建者
     */
    protected String createUser;

    /**
     * 创建时间
     */
    protected Date createDate;

    /**
     * 更新者
     */
    protected String updateUser;
    /**
     * 更新时间
     */
    protected  Date updateDate;
    /**
     * 删除标志
     */
    protected String delFlag;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    @Override
    public String toString() {
        return "BaseEntity{" +
                "id='" + id + '\'' +
                ", createUser='" + createUser + '\'' +
                ", createDate=" + createDate +
                ", updateUser='" + updateUser + '\'' +
                ", updateDate=" + updateDate +
                ", delFlag='" + delFlag + '\'' +
                '}';
    }
}
