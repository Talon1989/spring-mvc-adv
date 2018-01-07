package com.fabio.springmvc.services.security;

import com.fabio.springmvc.domain.User;
import com.fabio.springmvc.services.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginServiceImpl implements LoginService{

    private Logger log = Logger.getLogger(this.getClass());

    private UserService userService;

    @Autowired
    public LoginServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Scheduled(fixedRate = 60000)
    @Override
    public void resetFailedLogins() {
        log.info("Checking for locked accounts");
        List<User> users = (List<User>)userService.listAll();
        users.forEach(user->{
            if(! user.getEnabled()&&user.getFailedLoginAttempts()>0){
                log.info("Resetting failed attempts for user: "+user.getUsername());
                user.setFailedLoginAttempts(0);
                user.setEnabled(true);
                userService.saveOrUpdate(user);
            }
        });
    }
}
