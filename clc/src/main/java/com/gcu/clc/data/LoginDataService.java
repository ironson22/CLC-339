package com.gcu.clc.data;

import javax.sql.DataSource;
import com.gcu.clc.model.LoginModel;
import com.gcu.clc.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class LoginDataService {
    @Autowired
    private DataSource dataSource;

    private JdbcTemplate jdbcTemplateObject;

    public LoginDataService(DataSource dataSource){
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    public UserModel authenticateUser(LoginModel user){
        String sql = "SELECT * FROM users WHERE email = '" + user.getEmail() + "' AND password = '" + user.getPassword() + "'";
        //try catch block to catch any errors
        try{
            SqlRowSet rowSet = jdbcTemplateObject.queryForRowSet(sql);
            UserModel loginUser = new UserModel(rowSet.getLong("user_id"), rowSet.getString("fname"), rowSet.getString("lname"), rowSet.getString("password"), rowSet.getString("phone_number"), rowSet.getString("email"), rowSet.getString(""), rowSet.getString(""));
            //If the user is found, then the user is returned
            if(loginUser.getUserId() != -1){
                return loginUser;
            }
            //If the user is not found, then a null value is returned
            else{
                return null;
            }
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }

    }
}
