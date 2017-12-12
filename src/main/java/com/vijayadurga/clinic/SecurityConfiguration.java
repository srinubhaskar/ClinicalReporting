package com.vijayadurga.clinic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserDetailsService userService;
	
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		   httpSecurity.authorizeRequests().antMatchers("/hello", "/registration","/register","/static/**").permitAll()
           .and()
           .authorizeRequests().anyRequest().authenticated()
           .and()
           .formLogin()
           .loginPage("/hello")
           .loginProcessingUrl("/authenticate")
           .defaultSuccessUrl("/success")
           .successForwardUrl("/success")
           .failureForwardUrl("/hello")
           .and()
           .httpBasic();

   httpSecurity.logout()
           .logoutUrl("/logout")
           .logoutSuccessUrl("/hello")
           .invalidateHttpSession(true);
	}
	
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    	auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN", "USER");
    	auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
    }


}
