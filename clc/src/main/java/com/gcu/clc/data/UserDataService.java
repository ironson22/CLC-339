package com.gcu.clc.data;

import javax.sql.DataSource;

import com.gcu.clc.model.UserModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class UserDataService {
    @Autowired
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;
    
    public UserDataService(DataSource dataSource){
        this.dataSource = dataSource;
        jdbcTemplateObject = new JdbcTemplate(dataSource);

    }
    public UserModel findUser(String email){
        String sql = "SELECT * FROM eBuy.users WHERE email = " + email;
        UserModel user;
        try{
            SqlRowSet rowSet = jdbcTemplateObject.queryForRowSet(sql);
            user = new UserModel(rowSet.getString("user_id"), rowSet.getString("fname"), rowSet.getString("lname"), rowSet.getString("email"), rowSet.getString("profile_img"), rowSet.getString("address"));
            return user;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
