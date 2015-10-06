package br.com.questionario.servico.implementations;

import br.com.questionario.model.Destinatario;
import br.com.questionario.repository.implementations.DestinatarioDAO;
import br.com.questionario.servico.interfaces.IServiceDestinatario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
 *
 * @author EudesSilva
 * 
 */
@Service 
@Transactional
public class ServiceDestinatario implements IServiceDestinatario{
    
 
   @Autowired 
   private DestinatarioDAO destinatarioDAO;
    
   public void enviarQuestionario(int idQuestionario, String email){
      destinatarioDAO.enviarQuestionario(idQuestionario, email);
   }
    public boolean validarRespostaQuestionario(int idQuestionario, String email){
        return destinatarioDAO.validarRespostaQuestionario(idQuestionario, email);
    }
     
   public void registrarRespostaQuestionario(Destinatario destinatario){
       destinatarioDAO.registrarRespostaQuestionario(destinatario);
   } 
    
    
}
