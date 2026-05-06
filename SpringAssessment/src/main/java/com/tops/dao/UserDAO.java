package com.tops.dao;

import com.tops.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public boolean validateUser(User user) {

        String sql = "SELECT COUNT(*) FROM users WHERE username=? AND password=?";

        Integer count = jdbcTemplate.queryForObject(
                sql,
                new Object[]{user.getUsername(), user.getPassword()},
                Integer.class
        );

        return count != null && count > 0;
    }
}