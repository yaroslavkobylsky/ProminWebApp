package com.promin_ism.service.impl;

import com.promin_ism.dao.DatabaseException;
import com.promin_ism.dao.UserDao;
import com.promin_ism.model.User;
import com.promin_ism.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    public User read(Long id) throws DatabaseException {
        return userDao.read(id);
    }

    public void update(User user) throws DatabaseException {
        userDao.update(user);
    }

    public Long create(User user) throws DatabaseException {
        return userDao.create(user);
    }

    public void delete(User user) throws DatabaseException {
        userDao.delete(user);
    }

    public List<User> findAll() throws DatabaseException {
        return userDao.findAll();
    }
}
