package br.com.questionario.util;
 
import java.util.Properties; 
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSenderImpl;
/**
 *
 * @author EudesSilva
 * 
 */
 
@Configuration
@ComponentScan({ "br.com.questionario.configuration" })
public class SendMailConfig {
    
      private final String EMAIL = "seu_email@gmail.com";
      private final String PASSW = "sua_senha";
      private final String SMTP  = "smtp.gmail.com";   //Gmail
      
      
    // Problems in Gmail
    // https://support.google.com/mail/answer/13287?hl=en
    // Doc
    //http://docs.spring.io/spring/docs/3.0.x/spring-framework-reference/html/mail.html
    
      
 
	public JavaMailSenderImpl javaMailSenderImpl(){ 
            JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
            mailSender.setHost(SMTP);
            mailSender.setPort(587); 
            mailSender.setUsername( EMAIL );
            mailSender.setPassword( PASSW ); 
            Properties properties = new Properties(); 
            properties.put("mail.transport.protocol", "smtp");
            properties.put("mail.smtp.auth", "true"); 
            properties.put("mail.debug", "true"); 
            properties.put("mail.mime.charset", "ISO-8859-1"); 
            
            //GMAIL: Port for TLS/STARTTLS: 587 Port for SSL: 465
            properties.put("mail.smtp.starttls.enable", "true");  
            properties.put("mail.smtp.quitwait", "false");
           // properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            //properties.put("mail.smtp.socketFactory.fallback", "false"); 
            
            mailSender.setJavaMailProperties(properties); 
            return mailSender;
	}
}
