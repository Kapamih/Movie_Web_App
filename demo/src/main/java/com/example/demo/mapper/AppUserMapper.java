package com.example.demo.mapper;

import com.example.demo.model.AppUser;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AppUserMapper implements RowMapper<AppUser> {

    public static final String BASE_SQL //
            = "Select u.email, u.password From App_User u ";

    @Override
    public AppUser mapRow(ResultSet rs, int rowNum) throws SQLException {

        String email = rs.getString("email");
        String password = rs.getString("password");

        return new AppUser(email, password);
    }

}