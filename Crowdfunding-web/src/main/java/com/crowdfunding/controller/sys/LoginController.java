package com.crowdfunding.controller.sys;

import com.crowdfunding.entity.sys.UserInfo;
import com.crowdfunding.service.sys.UserService;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

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
    public Map<String,Object > userList(UserInfo userInfo) {
        Map<String,Object> map=new HashedMap();
        //判断是否存在该用户
        List<UserInfo> list = userService.findUserForLogin(userInfo.getLoginName(), userInfo.getPassword());
        if (list.size()<0) {
            map.put("false",1);
        } else {
            map.put("success",0);
        }
        return map;
    }
}
