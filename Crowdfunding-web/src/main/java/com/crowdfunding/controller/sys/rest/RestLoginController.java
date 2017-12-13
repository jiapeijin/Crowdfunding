package com.crowdfunding.controller.sys.rest;

import com.crowdfunding.entity.sys.UserInfo;
import com.crowdfunding.framework.redis.RedisUtil;
import com.crowdfunding.service.sys.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Dell on 2017/12/13.
 */
@Controller
@RequestMapping("/login")
public class RestLoginController {
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
    @RequestMapping(value = "/loginInto")
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
    @RequestMapping(value="/registUser")
    @ResponseBody
    public Map<String,Object> addUser(UserInfo userInfo) {
        return userService.addUser(userInfo);
    }
}
