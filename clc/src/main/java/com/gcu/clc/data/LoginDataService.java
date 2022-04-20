package com.gcu.clc.data;

import javax.sql.DataSource;
import com.gcu.clc.model.LoginModel;
import com.gcu.clc.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;
@Service
public class LoginDataService {
    @Autowired
    private DataSource dataSource;

    private JdbcTemplate jdbcTemplateObject;

    public LoginDataService(DataSource dataSource){
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    
    /** 
     * Authenticates the user 
     * @param user
     * @return UserModel
     */
    public UserModel authenticateUser(LoginModel user){
        //SQL statement that gets a user using their email and password
        String sql = "SELECT * FROM ebuy.users WHERE email = '" + user.getEmail() + "' AND password = '" + user.getPassword() + "'";
        //try catch block to catch any errors
        try{
            SqlRowSet rowSet = jdbcTemplateObject.queryForRowSet(sql);
            //Gets the result from the query and creates a user model
             try{
                rowSet.next();
                UserModel loginUser = new UserModel(rowSet.getLong("user_id"), rowSet.getString("fname"), rowSet.getString("lname"), rowSet.getString("password"), rowSet.getString("phone_number"), rowSet.getString("email"), "", rowSet.getString("address"));                
                return loginUser;
            }catch(Exception e){
                return new UserModel(-1L, "", "", "", "", "", "", "");
             }

        }catch(Exception e){
            System.out.print("Issues have occured");
            e.printStackTrace();
            return null;
        }

    }
}
