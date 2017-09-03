package com.cjimgarten.springboot;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by chris on 8/30/17.
 */
@SpringBootApplication
@Controller
public class SpringBootApp {

    private static final Logger LOG = LogManager.getLogger(SpringBootApp.class);

    @Value("${com.cjimgarten.springboot.firstname}") private String firstname;
    @Value("${com.cjimgarten.springboot.lastname}") private String lastname;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootApp.class, args);
        LOG.info("Application started...");
    }

    @RequestMapping("")
    @ResponseBody
    public String index() {
        LOG.info("Index route");
        String message = "Hello my name is " + firstname + " " + lastname;
        return message;
    }
}
