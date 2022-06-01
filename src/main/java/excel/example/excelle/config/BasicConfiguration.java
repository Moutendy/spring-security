package excel.example.excelle.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.http.HttpMethod;


@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class BasicConfiguration extends WebSecurityConfigurerAdapter{

	@Autowired
	private DataSource dataSource;
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	
	
		
		
		
		PasswordEncoder encoder = 
		          PasswordEncoderFactories.createDelegatingPasswordEncoder();
		auth.jdbcAuthentication()                
	    .dataSource(dataSource)                
	    .usersByUsernameQuery("select username as principal, password as credentials, true from users where username = ?")               
	    .authoritiesByUsernameQuery("select username as principal, authority as role from authorities where username = ?")                
	    .passwordEncoder(encoder);
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		   http
		 //HTTP Basic authentication
           .httpBasic()
           .and()
           .authorizeRequests()
           .antMatchers(HttpMethod.GET, "/listeUsers/**").hasRole("USER")
           .antMatchers(HttpMethod.POST, "/books").hasRole("ADMIN")
           .antMatchers(HttpMethod.PUT, "/books/**").hasRole("ADMIN")
           .antMatchers(HttpMethod.PATCH, "/books/**").hasRole("ADMIN")
           .antMatchers(HttpMethod.DELETE, "/books/**").hasRole("ADMIN")
           .and()
           .csrf().disable()
           .formLogin().disable();
	}
	
}
