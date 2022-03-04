package com.gcu.clc.data;

import javax.sql.DataSource;

import com.gcu.clc.model.RegistrationModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
@Service
public class RegisterDataService {
    @Autowired
    private DataSource dataSource;

    private JdbcTemplate jdbcTemplateObject;

    public RegisterDataService(DataSource dataSource){
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    public boolean createUser(RegistrationModel user){
        String sql = "INSERT INTO users(fname, lname, phone_number, email, address) VALUES (?, ?, ?, ?, ?)";
        try{
            int rows = jdbcTemplateObject.update(sql, user.getFirstName(), user.getLastName(), user.getPhoneNumber(), user.getEmail(), user.getAddress());
            return rows == 1;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
