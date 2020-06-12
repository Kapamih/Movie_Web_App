package com.example.demo.dao;

import com.example.demo.mapper.AppUserMapper;
import com.example.demo.model.AppUser;
import com.example.demo.utils.EncryptedPasswordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;

@Repository
@Transactional
public class AppUserDAO extends JdbcDaoSupport {
    EncryptedPasswordUtils encryptedPasswordUtils;

    private final String INSERT_SQL = "INSERT INTO App_User(email, password, ENABLED) values(:email,:password,:ENABLED)";
    @Autowired
    public AppUserDAO(DataSource dataSource) {
        this.setDataSource(dataSource);
    }

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public void create(final AppUser user) {
        KeyHolder holder = new GeneratedKeyHolder();
        String encrytedPassword = encryptedPasswordUtils.encrytePassword(user.getPassword());

        SqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("email", user.getEmail())
                .addValue("password", encrytedPassword)
                .addValue("ENABLED", 1);
        namedParameterJdbcTemplate.update(INSERT_SQL, parameters, holder);
    }
/*
    public void addUserAccount(String email,String password){
        String encrytedPassword = encryptedPasswordUtils.encrytePassword(password);
        String sql = "insert into App_User(email, password, ENABLED)\n" +
                "values ('"+email+"', '"+encrytedPassword+"', 1);" ;
        System.out.println("Registered Password: "+encrytedPassword);
        System.out.println("Sql query insert: "+sql);
        AppUser appUser = this.getJdbcTemplate().queryForObject(sql , AppUser.class);

    }*/
    public AppUser findUserAccount(String email) {
        // Select .. from App_User u Where u.User_Name = ?
        String sql = AppUserMapper.BASE_SQL + " where u.email = ? ";

        Object[] params = new Object[] { email };
        AppUserMapper mapper = new AppUserMapper();
        try {
            AppUser userInfo = this.getJdbcTemplate().queryForObject(sql, params, mapper);
            return userInfo;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

}