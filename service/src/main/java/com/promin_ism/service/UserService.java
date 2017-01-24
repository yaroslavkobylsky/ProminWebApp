package com.promin_ism.service;

import com.promin_ism.dao.DatabaseException;
import com.promin_ism.model.User;

import java.util.List;

public interface UserService {
    User read(Long id) throws DatabaseException;
    void update(User user) throws DatabaseException;
    Long create(User user) throws DatabaseException;
    void delete(User user) throws DatabaseException;
    List<User> findAll() throws DatabaseException;
    User getByLoginPass(String login, String password) throws DatabaseException;
}
