package com.gcu.clc.data;

import javax.servlet.http.HttpSession;
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
    @Autowired 
    private HttpSession session;
    private JdbcTemplate jdbcTemplateObject;

    public UserDataService(DataSource dataSource){
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    
    /** 
     * Finds a user by their email, used for logging in
     * @param email
     * @return UserModel
     */
    public UserModel findByUsername(String email){
        //SQL statement for getting a user
        String sql = "SELECT * FROM ebuy.users WHERE email='" + email +"'";
        try{
            SqlRowSet rowSet = jdbcTemplateObject.queryForRowSet(sql);
            //Checks if there is a user returned (.next()), and creates a User Model with the returned info
            try{
                rowSet.next();
                UserModel loginUser = new UserModel(rowSet.getLong("user_id"), rowSet.getString("fname"), rowSet.getString("lname"), rowSet.getString("password"), rowSet.getString("phone_number"), rowSet.getString("email"), "", rowSet.getString("address"));                
                //Adds an attribute to the session, indicating a user has been logged inwww
                session.setAttribute("loggedIn", true);
                return loginUser;  
            }catch(Exception e){
                return null;
            }
        }catch(Exception e){
            return null;
        }
    }
}
