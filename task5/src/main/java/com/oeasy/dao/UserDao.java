package com.oeasy.dao;

import com.oeasy.model.User;
import org.apache.ibatis.annotations.Param;

/**
 * 
 * @author alin
 *
 * 2017年6月13日
 */
public interface UserDao {
    public User selectByUserId(Long id);
    public User selectByUsername(String username);
    public int insert(@Param("username") String username, @Param("password") String password);
    public User verification(@Param("username") String username, @Param("password") String password);
}
