package br.com.questionario.configuration;
 
import javax.servlet.Filter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


/**
 *
 * @author EudesSilva
 * 
 */
//AbstractAnnotationConfigDispatcherServletInitializer registers dispatcher servlet. 
//This class provides different methods getRootConfigClasses(), getServletConfigClasses() and 
//getServletMappings() to configure config class and URL mapping. 


//http://docs.spring.io/spring-security/site/docs/4.0.2.RELEASE/reference/htmlsingle/#abstractsecuritywebapplicationinitializer-with-spring-mvc

public class SpringMvcInitializer extends AbstractAnnotationConfigDispatcherServletInitializer  {
    
    
    @Override
    protected Class<?>[] getRootConfigClasses() {
	return new Class[] { StartApplicationConfiguration.class };  // Load Configurations
    }
    
    
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return null;
    }
    
    
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    } 
    
    @Override
    protected Filter[] getServletFilters() {
    	Filter [] singleton = { new CORSFilter() };
    	return singleton;
    }
     
    
}
