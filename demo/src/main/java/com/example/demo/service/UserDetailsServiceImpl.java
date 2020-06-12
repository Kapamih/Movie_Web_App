package com.example.demo.service;

import com.example.demo.dao.AppMovieDAO;
import com.example.demo.dao.AppUserDAO;
import com.example.demo.model.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    public List<String> movies;
    @Autowired
    private AppUserDAO appUserDAO;

    @Autowired
    private AppMovieDAO appMovieDAO;

    public void addUser(AppUser appUser){
        appUserDAO.create(appUser);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        AppUser appUser = this.appUserDAO.findUserAccount(email);

        if (appUser == null) {
            System.out.println("User not found! " + email);
            throw new UsernameNotFoundException("User " + email + " was not found in the database");
        }

        System.out.println("Found User: " + appUser);

        // [ROLE_USER, ROLE_ADMIN,..]
        movies = this.appMovieDAO.getRoleNames(appUser.getEmail());

        List<String> authorityUsers = new ArrayList<String>();//prosthiki
        authorityUsers.add("ROLE_USER");

        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();

        for (String role : authorityUsers) {
            // ROLE_USER, ROLE_ADMIN,..
            GrantedAuthority authority = new SimpleGrantedAuthority(role);
            grantList.add(authority);
        }

        UserDetails userDetails = (UserDetails) new User(appUser.getEmail(), //
                appUser.getPassword(), grantList);

        return userDetails;
    }

    public List<String> getMovies(){return movies;}

}