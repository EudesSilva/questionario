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
    
    // @Autowired
    //private DataSource dataSource;
 
    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication().withUser("admin").password("123").roles("ADMIN");
        auth.inMemoryAuthentication().withUser("user").password("123").roles("USER");
        auth.inMemoryAuthentication().withUser("dba").password("123").roles("ADMIN","DBA"); 
        
         //auth.jdbcAuthentication()
         //    .dataSource(dataSource)
	 //    .withDefaultSchema()
	 //    .withUser("user").password("password").roles("USER");
    }
    
    
    
    
       
	@Override
	protected void configure(HttpSecurity http) throws Exception {
           ///http.authorizeRequests().antMatchers("/**").permitAll().and().csrf().disable();
	http.authorizeRequests()//.antMatchers("/resources/**").not().authenticated()
            .antMatchers("/resources/**", "/views/public/**").permitAll()                
            .antMatchers("/views/restrict/**").hasRole("ADMIN")                                                
            .and() 
	    .formLogin().loginPage("/login").defaultSuccessUrl("/views/restrict/home.html")
            .usernameParameter("ssoId").passwordParameter("password")
            //.failureUrl("/views/public/login.html")
            .and()
            .logout().logoutUrl("/logout").logoutSuccessUrl("/views/public/login-success.html").permitAll()
//.logoutUrl("/views/public/login.html")
            .invalidateHttpSession(true)
            .deleteCookies("JSESSIONID").permitAll() 
            .and().csrf().disable()
            .exceptionHandling().accessDeniedPage("/accessdenied");
            
            
        
        // infos 
        //https://spring.io/blog/2013/07/11/spring-security-java-config-preview-readability/
        // csrf() // https://en.wikipedia.org/wiki/Cross-site_request_forgery
        //http://docs.spring.io/spring-security/site/docs/4.0.2.RELEASE/reference/htmlsingle/#jc-hello-wsca
        
        
        
        
        
//		http 
//                .formLogin().loginPage("/public/login.jsp")
//                //.loginPage("/public/login")
//               // .usernameParameter("j_username")
//                //.passwordParameter("j_password")
//                //.loginPage("/public/login.jsp")
//                .failureUrl("/login?error")
//                .loginProcessingUrl("/restrict/welcome.jsp")
//                //.defaultSuccessUrl("/restrict/welcome.jsp")
//                .and()  
//                .logout().invalidateHttpSession(true)
//                 .deleteCookies("JSESSIONID").permitAll()
//                .and()
//                .authorizeRequests()
//                .antMatchers("/resources/**").permitAll()
//                .antMatchers("/public/**").permitAll()
//                .anyRequest().authenticated()
//.antMatchers(HttpMethod.POST, "/employees").hasRole("ADMIN")
//                .antMatchers("/restrict/**").access("hasRole('ROLE_ADMIN')")
//		.antMatchers("/app/admin/**").access("hasRole('ROLE_ADMIN')")
//                //.antMatchers("/app/admin/**").hasRole("ADMIN")
//		.antMatchers("/app/user/**").access("hasRole('ROLE_USER')");
	}
        
 

   
//    @Configuration
//    protected static class AuthenticationConfiguration extends GlobalAuthenticationConfigurerAdapter {
//            @Override
//            public void init(AuthenticationManagerBuilder auth) throws Exception {
//                
//                  auth.inMemoryAuthentication().withUser("user").password("123").roles("USER");
//                  auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN");
//
//            }
//    } 
}   
