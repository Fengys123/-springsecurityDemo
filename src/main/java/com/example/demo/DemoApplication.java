package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreFilter;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@RequestMapping("/")
	public String home(){
		return "hello spring boot";
	}

	@RequestMapping("/hello")
	public String hello(){
		return "hello word";
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostAuthorize("hasRole('')")
	@PreFilter("")
	@PostFilter("")
	@RequestMapping("/roleAuth")
	public String role(){
		return "admin auth";
	}

	@PreAuthorize("#id<10 and principal.username.equals(#username) and #user.username.equals('admin')")
	@PostAuthorize("returnObject%2==0")
	@PreFilter("")
	@PostFilter("")
	@RequestMapping("/test")
	public Integer test(Integer id, String username, User user){
		return id;
	}


	@PreFilter("filterObject%2==0")
	@PostFilter("filterObject%2==0 ")
	@RequestMapping("/test")
	public List<Integer> test(List<Integer> id){
		return id;
	}
}
