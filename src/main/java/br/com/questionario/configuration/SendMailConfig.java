package br.com.questionario.configuration;
 
 
import java.util.Enumeration;
import java.util.Properties; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSenderImpl;
/**
 *
 * @author EudesSilva
 * 
 */
 
@Configuration
@ComponentScan({ "br.com.questionario.configuration" })
@PropertySource(value = { "classpath:application.properties" })
public class SendMailConfig {
    
    
    
      @Autowired
      private Environment env;
// 
//      private final String EMAIL = "seu_email@gmail.com";  
//      private final String PASSW = "sua_senha";
//      private final String SMTP  = "smtp.gmail.com";   //Gmail
//      private final int    PORT  = 587;
      
      
      
    // Problems in Gmail
    // https://support.google.com/mail/answer/13287?hl=en
    // Doc
    //http://docs.spring.io/spring/docs/3.0.x/spring-framework-reference/html/mail.html
    
      
        @Bean
	public JavaMailSenderImpl javaMailSenderImpl(){ 
            JavaMailSenderImpl mailSender = new JavaMailSenderImpl(); 
            mailSender.setHost( env.getProperty("smtp.smtphost") );
            mailSender.setPort( env.getProperty("smtp.port", Integer.class) ); 
            mailSender.setUsername( env.getProperty("smtp.username") );
            mailSender.setPassword( env.getProperty("smtp.password") );   
 
            Properties properties = new Properties(); 
            properties.put("mail.transport.protocol", env.getProperty("mail.transport.protocol"));
            properties.put("mail.smtp.auth", env.getProperty("mail.smtp.auth")); 
            properties.put("mail.debug", env.getProperty("mail.debug")); 
            properties.put("mail.mime.charset", env.getProperty("mail.mime.charset")); 
            
            //GMAIL: Port for TLS/STARTTLS: 587 Port for SSL: 465
           // properties.put("mail.smtp.starttls.enable", "true");
            properties.put("mail.smtp.starttls.enable", env.getProperty("mail.smtp.starttls"));  
            properties.put("mail.smtp.quitwait", env.getProperty("mail.smtp.quitwait"));
            // properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            //properties.put("mail.smtp.socketFactory.fallback", "false");
 
            mailSender.setJavaMailProperties(properties); 
            return mailSender;
	}
  
      
        
        
}
