package br.com.test;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
/**
 *
 * @author EudesSilva
 * 
 */
 
public class SendMailTest {

    
 /*
We need to set MimeMessageHelper methods to send the email.
setFrom(): Sets sender email.
setTo(): Sets recipient email.
setSubject(): Sets the subject line of the email.
setText(): Write text to be sent as an email.
addAttachment(): Add attachment.
addCc(): Add cc recipient.
addBcc(): Add bcc recipient.  
 */   
    
    public static void main(String[] args) {
        try {
//            SimpleMailMessage mailMessage = new SimpleMailMessage();
//        mailMessage.setTo("someone@localhost");
//        mailMessage.setReplyTo("someone@localhost");
//        mailMessage.setFrom("someone@localhost");
//        mailMessage.setSubject("Lorem ipsum");
//        mailMessage.setText("Lorem ipsum dolor sit amet [...]");
            
            
            AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
            ctx.register(ConfigEmailTest.class);
            ctx.refresh();
            
            JavaMailSenderImpl mailSender = ctx.getBean(JavaMailSenderImpl.class);
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper msg = new MimeMessageHelper(mimeMessage);
            
            // String[] lista;
             //mailMsg.setTo(lista); 
            msg.setFrom("questionario@gmail.com");  // de
            msg.setTo("questionario@gmail.com");  // para
            msg.setSubject("Test mail");    // titulo 
            //mailMsg.setText(null, "text/html");
            msg.setText("<a href='http://google.com.br' target='_blank'>Hello World!</a>", true);
           
            
            mailSender.send(mimeMessage);
            System.out.println("---Done---");
        } catch (MessagingException ex) {
            Logger.getLogger(SendMailTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
