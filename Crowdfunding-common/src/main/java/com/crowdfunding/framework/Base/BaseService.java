package com.crowdfunding.framework.Base;

import com.crowdfunding.entity.sys.UserInfo;
import com.crowdfunding.framework.redis.RedisUtil;
import com.crowdfunding.framework.util.IdGen;

import java.util.Date;

/** 实体类的添加更新操作
 * Created by lucy on 2017/12/11.
 */
public class BaseService implements java.io.Serializable {
    UserInfo userInfo= (UserInfo) RedisUtil.jedisGetObject("loginInfo");

    /**
     * @param entity entity
     * @return T
     * @description 保存前赋值
     * @methodName preInsert
     * @author lucy [18616735761@163.com]
     * @time 2017/12/11 11:09
     */
    protected <T extends BaseEntity<T>> T preInsert(T entity) {
        entity.setId(IdGen.getId());
        entity.setCreateDate(new Date());
        entity.setUpdateDate(new Date());
        if(userInfo != null){
            entity.setCreateUser(userInfo.getLoginName());
            entity.setUpdateUser(userInfo.getLoginName());
        }
        entity.setDelFlag("0");
        return entity;
    }

    /**
     * @param entity entity
     * @return T
     * @description 更新前操作
     * @methodName preUpdate
     * @author lucy [18616735761@163.com]
     * @time 2017/12/11 11:10
     */
    protected <T extends BaseEntity<T>> T preUpdate(T entity) {
        entity.setUpdateDate(new Date());
         entity.setUpdateUser(userInfo.getLoginName());
        return entity;
    }
}
