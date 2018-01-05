package com.fabio.springmvc.services.mapservices;

import com.fabio.springmvc.domain.DomainObject;
import com.fabio.springmvc.domain.User;
import com.fabio.springmvc.services.UserService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

@Service
@Profile("map")
public class UserServiceImpl extends AbstractMapService implements UserService{

    @Override
    protected void loadDomainObjects() {

    }

    @Override
    public List<DomainObject> listAll() {
        return super.listAll();
    }

    @Override
    public User getById(Integer id) {
        return (User) super.getByid(id);
    }

    @Override
    public User saveOrUpdate(User domainObject) {
        return (User) super.saveOrUpdate(domainObject);
    }

    @Override
    public void delete(Integer id) {
        super.delete(id);
    }

    @Override
    public User findByUserName(String userName) {
        Optional returnUser = domainMap.values().stream().filter(new Predicate<DomainObject>() {
            @Override
            public boolean test(DomainObject domainObject) {
                User user = (User) domainObject;
                return user.getUsername().equalsIgnoreCase(userName);
            }
        }).findFirst();
        return (User) returnUser.get();
    }
}
