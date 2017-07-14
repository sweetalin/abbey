package com.oeasy.service.impl;

import com.oeasy.dao.UserDao;
import com.oeasy.model.User;
import com.oeasy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author alin
 *
 * 2017年6月13日
 */
@Service
public class UserServiceImpl implements UserService {
	@Autowired(required=false)
    private UserDao userDao;

    public User selectByUserId(Long id) {
        return userDao.selectByUserId(id);
    }

    public User selectByUsername(String username) {
        return userDao.selectByUsername(username);
    }

    public int insert(String username, String password) {
        return userDao.insert(username, password);
    }

    public boolean verification(String username, String password) {
        if (userDao.verification(username, password) == null) {
            return false;
        }
        return true;
    }
}
