package com.daydreamer.usersapi;

import com.daydreamer.usersapi.domain.Role;
import com.daydreamer.usersapi.domain.User;
import com.daydreamer.usersapi.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetailsPasswordService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class UsersapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsersapiApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}
	@Bean
	CommandLineRunner run(UserService userService){
		return args -> {
			userService.saveRole(new Role(null,"ROLE_USER"));
			userService.saveRole(new Role(null,"ROLE_MANAGER"));
			userService.saveRole(new Role(null,"ROLE_ADMIN"));
			userService.saveRole(new Role(null,"ROLE_ROOT"));
			userService.saveRole(new Role(null,"ROLE_LAWYER"));

			userService.saveUser(new User(null,"Jhon Doe","jhon","1234",new ArrayList<>()));
			userService.saveUser(new User(null,"Test User","test1","1234",new ArrayList<>()));
			userService.saveUser(new User(null,"Me User","me","1234",new ArrayList<>()));
			userService.saveUser(new User(null,"Soul Goodman","goodman","1234",new ArrayList<>()));

			userService.addRoleToUser("goodman","ROLE_USER");
			userService.addRoleToUser("goodman","ROLE_LAWYER");
			userService.addRoleToUser("me","ROLE_ADMIN");
			userService.addRoleToUser("me","ROLE_ROOT");
		};
	}
}
