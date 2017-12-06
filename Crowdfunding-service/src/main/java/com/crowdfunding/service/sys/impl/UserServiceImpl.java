package com.crowdfunding.service.sys.impl;

import com.crowdfunding.dao.sys.UserDao;
import com.crowdfunding.entity.sys.UserInfo;
import com.crowdfunding.framework.Page.PageBean;
import com.crowdfunding.framework.Page.PaginationContext;
import com.crowdfunding.service.sys.UserService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lucy on 2017/11/14.
 */
@Service
@Transactional(readOnly = false)
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;
    /**
     * @description 用户列表
     * @methodName findUserList
     * @param
     * @return java.util.List<com.crowdfunding.entity.sys.UserInfo>
     * @author lucy [18616735761@163.com]
     * @time 2017/11/14 13:57
     */
    @Override
    public PageBean<UserInfo> findUserList() {
        Map<String,Object> map = new HashMap<>();
        PageHelper.startPage(PaginationContext.getPageNum(),PaginationContext.getPageSize());
        List<UserInfo> list=userDao.findUserList();
        return new PageBean<UserInfo>(list);

    }
    /**
     * @description 添加用户
     * @methodName addUser
     * @param userInfo userInfo
     * @return int
     * @author lucy [18616735761@163.com]
     * @time 2017/11/14 13:58
     */
    @Override
    public int addUser(UserInfo userInfo) {
        return userDao.addUser(userInfo);
    }
    /**
     * @description 修改用户
     * @methodName editUser
     * @param userInfo userInfo
     * @return int
     * @author lucy [18616735761@163.com]
     * @time 2017/11/14 13:58
     */
    @Override
    public int editUser(UserInfo userInfo) {
        return userDao.editUser(userInfo);
    }
    /**
     * @description 删除用户
     * @methodName delUser
     * @param id id
     * @return int
     * @author lucy [18616735761@163.com]
     * @time 2017/11/14 13:58
     */
    @Override
    public int delUser(String id) {
        return userDao.delUser(id);
    }
    /**
     * @description 通过名字查找用户信息
     * @methodName findUserByName
     * @param loginName loginName
     * @return java.util.List<com.crowdfunding.entity.sys.UserInfo>
     * @author lucy [18616735761@163.com]
     * @time 2017/11/15 11:26
     */
    @Override
    public UserInfo findUserByName(String loginName) {
       return userDao.findUserByName(loginName);

    }
}
