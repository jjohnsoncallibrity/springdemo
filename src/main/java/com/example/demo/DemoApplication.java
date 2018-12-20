package com.example.demo;

import com.example.demo.entities.Link;
import com.example.demo.entities.User;
import com.example.demo.properties.DemoProperties;
import com.example.demo.service.LinkService;
import com.example.demo.service.UserService;
import org.ocpsoft.prettytime.PrettyTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@EnableConfigurationProperties(DemoProperties.class)
public class DemoApplication {

    @Autowired
    private DemoProperties demoProperties;

    @Autowired
    private UserService userService;

    @Autowired
    private LinkService linkService;

    private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    PrettyTime prettyTime() {
        return new PrettyTime();
    }

    @Bean
    @Profile("!prod")
    CommandLineRunner runner() {
        return (args) -> {
            log.debug(demoProperties.getWelcomeMessage());
            User jason = userService.getUserByUsername("jasonjohnson");
            log.debug("User id for jasonjohnson: " + jason.getId());
//            jason.setPassword((new BCryptPasswordEncoder()).encode("jason123"));
//            userService.save(jason);

            Link link = linkService.getLinkById(7L);
            log.debug("Link id 7 created on " + link.getPrettyTime());
        };
    }
}
