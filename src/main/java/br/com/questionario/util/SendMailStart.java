package br.com.questionario.util;

import br.com.questionario.configuration.SendMailConfig;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
/**
 *
 * @author EudesSilva
 * 
 */
 
@Component
public class SendMailStart {

    
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
    
    private final String remetente = "remetente___@gmail.com";
 
    
    @Autowired
    private JavaMailSenderImpl javaMail;
    
    @Autowired
    private SendMailConfig config;
    
    public boolean sendMail(String destinatario, String assunto, String msgHtmlText) {
        try { 
             
            javaMail = config.javaMailSenderImpl();
            MimeMessage mimeMessage = javaMail.createMimeMessage();
            MimeMessageHelper msg = new MimeMessageHelper(mimeMessage);
            msg.setFrom(remetente);  
            msg.setTo(destinatario);
            msg.setSubject(assunto);
            msg.setText(msgHtmlText, true); 
          //mailMsg.setTo(String[]); 
 
            javaMail.send(mimeMessage);
            
            System.out.println("---::::::::: Email Enviado::::::::---");
            
        } catch (MessagingException ex) { 
            ex.printStackTrace();
            return false;
        }
        return true;
    }
    
}
