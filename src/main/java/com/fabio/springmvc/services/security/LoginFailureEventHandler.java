package com.fabio.springmvc.services.security;

import com.fabio.springmvc.domain.User;
import com.fabio.springmvc.services.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
public class LoginFailureEventHandler implements ApplicationListener<LoginFailureEvent> {

    private Logger log = Logger.getLogger(this.getClass());

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void onApplicationEvent(LoginFailureEvent event) {
        Authentication authentication = (Authentication) event.getSource();
        log.warn("LoginEvent failure for: "+authentication.getPrincipal());
        User user = userService.findByUserName((String)authentication.getPrincipal());
        if(user!=null){
            user.setFailedLoginAttempts(user.getFailedLoginAttempts()+1);
            if(user.getFailedLoginAttempts()>3){
                user.setEnabled(false);
            }
            log.warn("VALID USERNAME, UPDATING FAILED ATTEMPTS");
            userService.saveOrUpdate(user);
        }
    }
}
