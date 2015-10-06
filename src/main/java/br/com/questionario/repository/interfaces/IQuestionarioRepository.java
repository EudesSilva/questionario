package br.com.questionario.repository.interfaces;

import br.com.questionario.dao.generic.IAbstractDAO; 
import br.com.questionario.model.Questionario;
import java.util.List;
/**
 *
 * @author EudesSilva
 * 
 */
 
public interface IQuestionarioRepository extends IAbstractDAO<Questionario, Long> {
	
 
     void saveQuestionario(Questionario questionario);
     List<Questionario> listarQuestionarios(int idUser);
  
}
 
