package com.crowdfunding.controller.sys.rest;

import com.crowdfunding.entity.sys.UserInfo;
import com.crowdfunding.framework.redis.RedisUtil;
import com.crowdfunding.service.sys.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * 登录controller
 */
@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private UserService userService;

    /**
     * @param userInfo userInfo
     * @return
     * @description 登录
     * @methodName
     * @author lucy [18616735761@163.com]
     * @time 2017/12/7 15:34
     */
    @RequestMapping(value = "/loginInto", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> userList(UserInfo userInfo) {
        Map<String, Object> map = new HashMap<String, Object>();
        //判断是否存在该用户
        UserInfo user = userService.findUserForLogin(userInfo.getLoginName(), userInfo.getPassword());
        if (user == null) {
            map.put("false", 1);
        } else {
            //将用户信息存入redis中
            RedisUtil.jedisPutObject("loginInfo",user);
            map.put("success", 0);
        }
        return map;
    }

    /**
     * @param userInfo
     * @return
     * @description 快速注册用户
     * @methodName
     * @author lucy [18616735761@163.com]
     * @time 2017/12/8 14:18
     */
    @RequestMapping("/registUser")
    public Map<String, Object> addUser(UserInfo userInfo) {
        Map<String, Object> map = new HashMap<String, Object>();
        int count = userService.addUser(userInfo);
        if (count > 0) {
            map.put("success", 0);
            return map;
        } else


        return map;
    }

}
