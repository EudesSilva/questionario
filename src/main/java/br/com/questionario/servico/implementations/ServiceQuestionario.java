package br.com.questionario.servico.implementations;
 
 
import br.com.questionario.model.Questionario;
import br.com.questionario.repository.implementations.QuestionarioDAO;
import br.com.questionario.servico.interfaces.IServiceQuestionario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
/**
 *
 * @author EudesSilva
 * 
 */


@Service 
@Transactional//(readOnly = true)
public class ServiceQuestionario implements IServiceQuestionario{

    
    @Autowired 
    QuestionarioDAO questionarioDAO;
    
    
   //@Transactional(readOnly = false, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT ) 
   public void saveQuestionario(Questionario questionario) {
       questionarioDAO.saveQuestionario(questionario);
   }
   
   
  // @Transactional(readOnly = false, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT ) 
  // @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW, isolation = Isolation.DEFAULT)
   public List<Questionario> listarQuestionariosUsuario(int idUser){
      return questionarioDAO.listarQuestionarios(idUser);
   }  
    
}
