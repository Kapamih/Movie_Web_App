package com.example.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.List;

@Repository
@Transactional
public class AppMovieDAO extends JdbcDaoSupport {

    //Epistrefi mia lista roles me tis tenies kathe xristi
    @Autowired
    public AppMovieDAO(DataSource dataSource) {
        this.setDataSource(dataSource);
    }
    //lista me ola ta movies
    public List<String> getRoleNames(String email) {
        String sql = "Select ur.movie_id " //
                + " from User_Movie ur" //
                + " where  ur.email = ? ";

        Object[] params = new Object[] { email };

        List<String> movies = this.getJdbcTemplate().queryForList(sql, params, String.class);
        for(String i:movies) System.out.println(i);
        return movies;
    }

}