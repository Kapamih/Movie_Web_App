package com.example.demo.controller;

import com.example.demo.model.AppUser;
import com.example.demo.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

@Controller
public class MainController {
    private String movies="";

    @Autowired
    private UserDetailsServiceImpl service;

    @RequestMapping(value = { "/","/Home" }, method = RequestMethod.GET)
    public String welcomePage() {
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(Model model) {
        model.addAttribute("appUser", new AppUser());
        return "form";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String RegisterSuccessfulPage(@ModelAttribute AppUser appUser) {

        service.addUser(appUser);
        return "registerSuccessfulPage";

    }

    @RequestMapping(value = "/userInfo", method = RequestMethod.GET)
    public String userInfo(Principal principal) {

        // After user login successfully.

        String userName = principal.getName();

        System.out.println("User Name: " + userName);

        return "index";
    }

    @RequestMapping(value = "/bookmarks", method = RequestMethod.GET)
    public String adminPage(Model model) {

        for(String m:service.getMovies()){
            movies+=m+"@";
        }

        model.addAttribute("userInfo", ""+movies);
        movies="";

        return "bookmarks";
    }


    @RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
    public String logoutSuccessfulPage(Model model) {
        return "logoutSuccessfulPage";
    }

}