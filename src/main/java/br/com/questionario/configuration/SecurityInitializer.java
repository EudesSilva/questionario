package br.com.questionario.configuration;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

 
/**
 *
 * @author EudesSilva
 * 
 */
//AbstractSecurityWebApplicationInitializer provides the availability of 
 //DelegatingFilterProxy and ContextLoaderListener and are registered automatically. 
 
 
/**
 * No customizations of {@link AbstractSecurityWebApplicationInitializer} are necessary.
 */
//http://docs.spring.io/spring-security/site/docs/4.0.2.RELEASE/reference/htmlsingle/#abstractsecuritywebapplicationinitializer-without-existing-spring
public class SecurityInitializer extends AbstractSecurityWebApplicationInitializer {
    
 
}