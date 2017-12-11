package com.crowdfunding.service.sys;


import com.crowdfunding.entity.sys.UserInfo;
import com.crowdfunding.framework.Page.PageBean;
import org.apache.ibatis.annotations.Param;

/**
 * Created by lucy on 2017/11/14.
 */
public interface UserService {
    /**
     * @param
     * @return
     * @description 用户列表
     * @methodName
     * @author lucy [18616735761@163.com]
     * @time 2017/11/14 10:41
     */
    PageBean<UserInfo> findUserList();

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
     * @param loginName loginName
     * @return java.util.List<com.crowdfunding.entity.sys.UserInfo>
     * @description 通过名字查询用户信息
     * @methodName findUserByName
     * @author lucy [18616735761@163.com]
     * @time 2017/11/15 11:25
     */
    UserInfo findUserByName(@Param("loginName") String loginName);

    /**
     * @param loginName loginName
     * @param password  password
     * @return int
     * @description 登录
     * @methodName findUserForLogin
     * @author lucy [18616735761@163.com]
     * @time 2017/12/7 16:06
     */
    UserInfo findUserForLogin(@Param("loginName") String loginName, @Param("password") String password);
}
