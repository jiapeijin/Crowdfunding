package com.crowdfunding.dao.sys;


import com.crowdfunding.entity.sys.UserInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by lucy on 2017/11/14.
 */
@Repository
public interface UserDao {
    /**
     * @param
     * @return
     * @description 用户列表
     * @methodName
     * @author lucy [18616735761@163.com]
     * @time 2017/11/14 10:41
     */
    List<UserInfo> findUserList();

    /**
     * @param userInfo userInfo
     * @return int
     * @description 用户添加
     * @methodName addUser
     * @author lucy [18616735761@163.com]
     * @time 2017/11/14 10:43
     */
    int addUser(UserInfo userInfo);

    /**
     * @param userInfo userInfo
     * @return int
     * @description 用户修改
     * @methodName editUser
     * @author lucy [18616735761@163.com]
     * @time 2017/11/14 10:44
     */
    int editUser(UserInfo userInfo);

    /**
     * @param id id
     * @return int
     * @description 用户删除
     * @methodName delUser
     * @author lucy [18616735761@163.com]
     * @time 2017/11/14 10:45
     */
    int delUser(@Param("id") String id);
    /**
     * @description 通过名字查询用户信息
     * @methodName findUserByName
     * @param loginName loginName
     * @return java.util.List<com.crowdfunding.entity.sys.UserInfo>
     * @author lucy [18616735761@163.com]
     * @time 2017/11/15 11:25
     */
    UserInfo findUserByName(@Param("loginName") String loginName);
    /**
     * @description
     * @methodName findUserForLogin
     * @param loginName loginName
     * @param password password
     * @return int
     * @author lucy [18616735761@163.com]
     * @time 2017/12/7 16:01
     */
    UserInfo findUserForLogin(@Param("loginName") String loginName, @Param("password") String password);
}
