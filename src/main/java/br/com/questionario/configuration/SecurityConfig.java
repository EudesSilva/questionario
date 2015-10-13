package br.com.questionario.configuration;
 

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder; 
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
/**
 *
 * @author EudesSilva
 * 
 */



//WebSecurityConfigurerAdapter provides the base class for WebSecurityConfigurer. 
//WebSecurityConfigurerAdapter has a method configure() that can be overridden to configure
//role and URL pattern. It also provides a default form login. In our security config class, 
//there are two roles USER and ADMIN. There are two URL pattern one for admin and another USER. 
//<input type="hidden"
//name="${_csrf.parameterName}"
//value="${_csrf.token}"/>

@Configuration 
@EnableWebSecurity 
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    
 
    @Autowired 
    CustomUserDetailsService customDetailsService;
  
 
 
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception { 
        auth.userDetailsService(customDetailsService); 
    }
 
        
       
	@Override
	protected void configure(HttpSecurity http) throws Exception {
     
	http.authorizeRequests() 
            .antMatchers("/resources/**", "/views/public/**").permitAll()
            .antMatchers("/views/restrict/**").hasRole("ADMIN") 
            .and() 
	    .formLogin().loginPage("/login") 
            .usernameParameter("ssoId").passwordParameter("password") 
            .failureUrl("/views/public/login.html/#/!/?error_login=true") 
            .successHandler( new CustomAuthSuccessHandler() )    // defaultSuccessUrl
            .and()
            .logout().logoutUrl("/logout")
            .logoutSuccessUrl("/views/public/login.html/#/!/?logoutOk=true").permitAll()
            .invalidateHttpSession(true)
            .deleteCookies("JSESSIONID").permitAll() 
            .and().csrf().disable()  // CSRF disable 
            //.anyRequest() .authenticated().and().addFilterAfter(new CsrfHeaderFilter(), CsrfFilter.class);
            .exceptionHandling().accessDeniedPage("/accessdenied");
            
            
        
        // infos 
        //https://spring.io/blog/2013/07/11/spring-security-java-config-preview-readability/
        // csrf() // https://en.wikipedia.org/wiki/Cross-site_request_forgery
        //http://docs.spring.io/spring-security/site/docs/4.0.2.RELEASE/reference/htmlsingle/#jc-hello-wsca
        
 
	}    
  
}   
