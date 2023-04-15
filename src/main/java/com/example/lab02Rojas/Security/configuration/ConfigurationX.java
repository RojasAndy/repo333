package com.example.lab02Rojas.Security.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Configuration
@EnableWebSecurity
@SuppressWarnings("deprecation")
public class ConfigurationX extends WebSecurityConfigurerAdapter{

	@Autowired
	private DataSource ds;
	
	@Autowired
	private BCryptPasswordEncoder passEncripta;
	
	@Autowired
	public void autenticacion(AuthenticationManagerBuilder bld) {
		try {
			bld.jdbcAuthentication().passwordEncoder(passEncripta).dataSource(ds).usersByUsernameQuery("SELECT usuario, PASSWORD, activo FROM users WHERE usuario=?").authoritiesByUsernameQuery("SELECT usuario, role FROM users WHERE usuario=?");		
		}catch(Exception e) {
			System.out.println("Error x");
		}
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
	    web.ignoring().
	        antMatchers("/register/**");
	      // (7)
	  }


	
}
