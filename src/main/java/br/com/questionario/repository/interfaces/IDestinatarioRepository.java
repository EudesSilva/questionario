package br.com.questionario.repository.interfaces;

 
import br.com.questionario.dao.generic.IAbstractDAO;  
import br.com.questionario.model.Destinatario;
/**
 *
 * @author EudesSilva
 * 
 */
  
public interface IDestinatarioRepository extends IAbstractDAO<Destinatario, Long> {
	
     void enviarQuestionario(int idQuestionario, String email); 
     boolean validarRespostaQuestionario(int idQuestionario, String email);
     void  registrarRespostaQuestionario(Destinatario destinatario);
}