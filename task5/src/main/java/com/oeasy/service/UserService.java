package com.oeasy.service;

import com.oeasy.model.User;

/**
 * 
 * @author alin
 *
 * 2017年6月13日
 */
public interface UserService {
    public User selectByUserId(Long id);
    public User selectByUsername(String username);
    public int insert(String username, String password);
    public boolean verification(String username, String password);
}
