package br.com.questionario.repository.implementations;

import br.com.questionario.dao.generic.AbstractDAO;
import br.com.questionario.model.Destinatario;
import br.com.questionario.model.Pergunta;
import br.com.questionario.model.Questionario;
import br.com.questionario.repository.interfaces.IDestinatarioRepository;  
import br.com.questionario.util.SendMailStart;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository; 
 /**
 *
 * @author EudesSilva
 * 
 */


@Repository
public class DestinatarioDAO extends AbstractDAO<Long, Destinatario> implements IDestinatarioRepository{
 
    Logger logger = LoggerFactory.getLogger(DestinatarioDAO.class);

  
   public void enviarQuestionario(int idQuestionario, String emailDestinatario){ 
       
      DetachedCriteria criteria = DetachedCriteria.forClass(Questionario.class);
      criteria.add( Restrictions.idEq(idQuestionario));
      Questionario questionario = (Questionario)criteria.getExecutableCriteria(getSession()).uniqueResult();
    
      // email enviado.... FAZER...
      String emailDest = emailDestinatario; // pega o email para formar o link;;;; 
      
      Destinatario destinatario = new Destinatario();
      destinatario.setEmailDestinatario( emailDest );
      destinatario.setRespondido(false);
      destinatario.setQuestionario(questionario);
      
      persist(destinatario);
      
      int id = destinatario.getIdDestinatario();
      
      logger.info("::Destinatario persistido: " +  id );
      logger.info("::Destinatario persistido: " + destinatario.getEmailDestinatario() );
      
      
      
      String link = "<a href='http://localhost:8084/questionario/views/public/responde.html#/q/"
                    + idQuestionario +"/id/"+ id + "/e/" + emailDest +"' target='_blank'>Responder Questionario</a>";
    
      SendMailStart sendMailStart = new SendMailStart();
      sendMailStart.sendMail(emailDestinatario, "Questionário", link );
      
      

      
      
   }
  
   
   public boolean validarRespostaQuestionario(int idQuestionario, String email){
    DetachedCriteria criteria = DetachedCriteria.forClass( Destinatario.class);
    criteria.add( Restrictions.eq("questionario.idQuestionario", idQuestionario)) 
    .add( Restrictions.eq("emailDestinatario", email))
    .add( Restrictions.eq("respondido", true));    
     Destinatario destinatario = (Destinatario) criteria.getExecutableCriteria(getSession()).uniqueResult();
    return destinatario != null;
   }

   public void registrarRespostaQuestionario(Destinatario destinatario){
       
       logger.info("registrarRespostaQuestionario:: ", destinatario);
       
       destinatario.setRespondido(true);  // force  ( :
       
       update(destinatario);
   }
   
}