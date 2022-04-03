package com.gcu.clc.data;

import javax.sql.DataSource;

import com.gcu.clc.model.UserModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;
@Service
public class UserDataService {
    @Autowired
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

    public UserDataService(DataSource dataSource){
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    public UserModel findByUsername(String email){
        String sql = "SELECT * FROM ebuy.users WHERE email='" + email +"'";
        try{
            SqlRowSet rowSet = jdbcTemplateObject.queryForRowSet(sql);
            try{
                rowSet.next();
                UserModel loginUser = new UserModel(rowSet.getLong("user_id"), rowSet.getString("fname"), rowSet.getString("lname"), rowSet.getString("password"), rowSet.getString("phone_number"), rowSet.getString("email"), "", rowSet.getString("address"));                
                return loginUser;  
            }catch(Exception e){
                return null;
            }
        }catch(Exception e){
            return null;
        }
    }
}
