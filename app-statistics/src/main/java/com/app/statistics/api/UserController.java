package com.app.statistics.api;

import com.app.statistics.model.UserModel;
import com.app.statistics.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/user")
public class UserController {
    @Autowired
    private UserService userServiceImpl;

    @RequestMapping(method = RequestMethod.GET, value = "/{id}", produces = "application/json")
    public UserModel findUserById(@PathVariable Long id){
        return userServiceImpl.getUser(id);
    }
}