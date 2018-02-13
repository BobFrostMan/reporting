package com.app.statistics.service.impl;

import com.app.statistics.entity.UserEntity;
import com.app.statistics.exception.UserNotFoundException;
import com.app.statistics.precondition.Precondition;
import com.app.statistics.mapper.BeanMapper;
import com.app.statistics.model.UserModel;
import com.app.statistics.repository.UserRepository;
import com.app.statistics.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BeanMapper mapper;

    public UserModel getUser(final Long id) {
        final UserEntity user = userRepository.findOne(id);
        Precondition.checkArgument(user != null, new UserNotFoundException());
        return mapper.map(user, UserModel.class);
    }
}