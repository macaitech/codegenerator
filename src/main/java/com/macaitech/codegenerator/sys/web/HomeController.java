package com.macaitech.codegenerator.sys.web;

import com.macaitech.codegenerator.sys.model.User;
import com.macaitech.codegenerator.sys.service.UserService;
import com.macaitech.codegenerator.vo.ResultData;
import com.macaitech.common.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController extends BaseController{

    @Autowired
    private HttpSession session;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String signIn() {
        return "sys/home";
    }

    @RequestMapping(value = "/signIn", method = RequestMethod.POST)
    @ResponseBody
    public ResultData<User> signIn(@RequestBody User user) {
        ResultData<User> result = userService.signIn(user);
        if (result.isSuccess()) {
            user = result.getData();
            session.setAttribute("User", user);
        }
        return result;
    }

    @RequestMapping(value = "/signOut", method = RequestMethod.GET)
    public String signOut() {
        session.invalidate();
        return "redirect:" + adminPath;
    }

}
