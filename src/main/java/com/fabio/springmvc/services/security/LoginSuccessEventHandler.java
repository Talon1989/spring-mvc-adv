package com.fabio.springmvc.services.security;

import com.fabio.springmvc.domain.User;
import com.fabio.springmvc.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class LoginSuccessEventHandler implements ApplicationListener<LoginSuccessEvent>{

    private UserService userService;

    @Autowired
    public LoginSuccessEventHandler(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void onApplicationEvent(LoginSuccessEvent event) {
        Authentication authentication = (Authentication) event.getSource();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        User user = userService.findByUserName(userDetails.getUsername());
        if(user!=null){
            user.setFailedLoginAttempts(0);
            System.out.println("Failed logins set to 0");
            userService.saveOrUpdate(user);
        }
    }
}
