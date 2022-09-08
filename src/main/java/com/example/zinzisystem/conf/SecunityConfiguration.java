package com.example.zinzisystem.conf;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class SecunityConfiguration {
	
	@Autowired
	private DataSource dataSource;
	
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.formLogin(login -> login
                .loginProcessingUrl("/login")
                .loginPage("/login")
                .permitAll()
                .defaultSuccessUrl("/")
        ).logout(logout -> logout
    			.logoutUrl("/logout")
    			.logoutSuccessUrl("/login")
    			.invalidateHttpSession(true)
    			.deleteCookies("JSESSIONID")
        ).authorizeHttpRequests(authz -> authz
        		.antMatchers("/css/**").permitAll()
    			.anyRequest().authenticated()
        );
        return http.build();
    }
	
//	@Bean
//	CustomUserDetailsService customUserDetailsService() {
//		return new CustomUserDetailsService();
//	}
	
	
//	@Bean
//	public InMemoryUserDetailsManager userDetailsService() {
//		
//        UserDetails user = User.withUsername("kondo")
//                .password(
//                        PasswordEncoderFactories
//                                .createDelegatingPasswordEncoder()
//                                .encode("1998"))
//                .roles("USER")
//                .build();
//        return new InMemoryUserDetailsManager(user);
//	}
	
	
//	@Bean
//	public UserDetailsManager userDetails() {
//		
//		JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
//		
//        UserDetails user = User.withUsername("kondo")
//                .password(
//                PasswordEncoderFactories
//                        .createDelegatingPasswordEncoder()
//                        .encode("1998"))
//                .roles("USER")
//                .build();
//        users.createUser(user);
//        return users;
//		
//		
//	}
	
	
//	@Bean
//	public UserDetailsManager userDetailsService(){
//	    
//	    JdbcUserDetailsManager users = new JdbcUserDetailsManager(this.dataSource);
//	    return users;
//	}
	
	
   // @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }

}
