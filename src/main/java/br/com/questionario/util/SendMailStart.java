package br.com.questionario.util;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
/**
 *
 * @author EudesSilva
 * 
 */
 
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
    
    private final String remetente = "remetente__@gmail.com";
 
    
    public boolean sendMail(String destinatario, String assunto, String msgHtmlText) {
        try { 
            SendMailConfig config = new SendMailConfig();
            JavaMailSenderImpl javaMail = config.javaMailSenderImpl();
            MimeMessage mimeMessage = javaMail.createMimeMessage();
            MimeMessageHelper msg = new MimeMessageHelper(mimeMessage);
            msg.setFrom(remetente);  
            msg.setTo(destinatario);
            msg.setSubject(assunto);
            msg.setText(msgHtmlText, true); 
          //mailMsg.setTo(String[]); 
            
            javaMail.send(mimeMessage);
            
            System.out.println("--- Email Enviado::::::::---");
            
        } catch (MessagingException ex) { 
            ex.printStackTrace();
            return false;
        }
        return true;
    }
    
}
