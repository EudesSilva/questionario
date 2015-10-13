package br.com.questionario.configuration;
 
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;  
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
/**
 *
 * @author EudesSilva
 * 
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "br.com.questionario")
public class StartApplicationConfiguration extends WebMvcConfigurerAdapter {
 
	
	/*  static resources like CSS / Javascript / HTML  */
    @Override 
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/"); 
        registry.addResourceHandler("/views/**").addResourceLocations("/views/"); 
    }
    
 
    
}