package br.com.questionario.configuration;
 
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;  
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
/**
 *
 * @author EudesSilva
 * 
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "br.com.questionario")
public class StartApplicationConfiguration extends WebMvcConfigurerAdapter {
	
//  @Override
//  public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
//    configurer.favorPathExtension(false).
//            favorParameter(true).
//            parameterName("mediaType").
//            ignoreAcceptHeader(true).
//            useJaf(false).
//            defaultContentType(MediaType.TEXT_HTML).
//            mediaType("html", MediaType.TEXT_HTML).
//            mediaType("xml", MediaType.APPLICATION_XML).
//            mediaType("json", MediaType.APPLICATION_JSON);
//  }
//  
  
	
//	@Override
//	public void configureViewResolvers(ViewResolverRegistry registry) {
//		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver(); 
//		viewResolver.setViewClass(JstlView.class);
//		viewResolver.setPrefix("/views/");
//		viewResolver.setSuffix(".jsp");
//		registry.viewResolver(viewResolver); 
//                 
//	}
	
	/*  static resources like CSS / Javascript / HTML  */
    @Override 
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/"); 
        registry.addResourceHandler("/views/**").addResourceLocations("/views/"); 
    }
    
 
    
}