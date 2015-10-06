package br.com.questionario.repository.interfaces;

import br.com.questionario.dao.generic.IAbstractDAO;
import br.com.questionario.model.Pergunta; 
import java.util.List;
 /**
 *
 * @author EudesSilva
 * 
 */


public interface IPerguntaRepository extends IAbstractDAO<Pergunta, Long> {
	
 
     void salvarPergunta(Pergunta pergunta);
     Pergunta findByIdPergunta(Long idPergunta);
     void deletePergunta(Pergunta pergunta);
     List<Pergunta> getAllPerguntasQuestionario(int idQuestionario);
    
  
}
