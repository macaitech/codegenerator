package com.macaitech.codegenerator.sys.web;

import org.springframework.beans.factory.annotation.Autowired;

import com.macaitech.codegenerator.interceptor.annotation.RequireSession;
import com.macaitech.codegenerator.sys.model.User;

import javax.servlet.http.HttpSession;

@RequireSession
public class AuthorizedController {

    @Autowired
    private HttpSession session;

    public User getUser() {
        return (User) session.getAttribute("User");
    }
}
