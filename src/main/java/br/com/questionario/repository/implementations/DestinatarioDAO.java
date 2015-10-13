package br.com.questionario.repository.implementations;

import br.com.questionario.dao.generic.AbstractDAO;
import br.com.questionario.model.Destinatario;
import br.com.questionario.model.Questionario;
import br.com.questionario.repository.interfaces.IDestinatarioRepository;  
import br.com.questionario.util.MyLogger;
import br.com.questionario.util.SendMailStart;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository; 
 /**
 *
 * @author EudesSilva
 * 
 */


@Repository
public class DestinatarioDAO extends AbstractDAO<Long, Destinatario> implements IDestinatarioRepository{
 
 
    private final MyLogger LOG = MyLogger.configLog(DestinatarioDAO.class);
    
    @Autowired 
    private SendMailStart sendMailStart;
  
   public void enviarQuestionario(int idQuestionario, String emailDestinatario){ 
       
      DetachedCriteria criteria = DetachedCriteria.forClass(Questionario.class);
      criteria.add( Restrictions.idEq(idQuestionario));
      Questionario questionario = (Questionario)criteria.getExecutableCriteria(getSession()).uniqueResult();
    
      // email .....
      String emailDest = emailDestinatario; 
      
      Destinatario destinatario = new Destinatario();
      destinatario.setEmailDestinatario( emailDest );
      destinatario.setRespondido(false);
      destinatario.setQuestionario(questionario);
      
      persist(destinatario);
      
      int id = destinatario.getIdDestinatario();
      
      LOG.myLog("::Destinatario persistido: " +  id );
      LOG.myLog("::Destinatario persistido: " + destinatario.getEmailDestinatario() );
      
      
      
      String link = "<a href='http://localhost:8084/questionario/views/public/responde.html#/q/"
                    + idQuestionario +"/id/"+ id + "/e/" + emailDest +"' target='_blank'>Responder Questionario</a>";
    
     // SendMailStart sendMailStart = new SendMailStart();
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
       
       LOG.myLog("registrarRespostaQuestionario:: "+ destinatario);
       
       destinatario.setRespondido(true);  // force  ( :
       
       update(destinatario);
   }
   
}