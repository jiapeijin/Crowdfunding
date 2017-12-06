package com.crowdfunding.controller.sys;

import com.crowdfunding.entity.sys.UserInfo;
import com.crowdfunding.service.sys.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lucy on 2017/11/14.
 */
@Controller
@RequestMapping("/system")
public class UserController {
    @Autowired
    private UserService userService;
    /**
     * @description 用户列表页
     * @methodName userList
     * @param
     * @return java.lang.String
     * @author lucy [18616735761@163.com]
     * @time 2017/11/14 16:07
     */
    @RequestMapping("/userList")
    public String userList(Model model){
        model.addAttribute("page",userService.findUserList());
        return "module/sys/userInfoList";
    }
    /**
     * @description 用户修改添加页
     * @methodName userEdit
     * @param
     * @return java.lang.String
     * @author lucy [18616735761@163.com]
     * @time 2017/11/15 9:54
     */
    @RequestMapping("/userEditShow")
    public String userEdit(String loginName,Model model){
        if(loginName != null){
           //修改 查询出用户原数据
           UserInfo userInfo=userService.findUserByName(loginName);
           model.addAttribute("list",userInfo);
        }
        return "module/sys/userInfoEdit";
    }
}
