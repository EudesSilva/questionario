package br.com.questionario.repository.interfaces;

 
import br.com.questionario.dao.generic.IAbstractDAO;  
import br.com.questionario.model.Resposta;
import java.util.List;
/**
 *
 * @author EudesSilva
 * 
 */
 

public interface IRespostaRepository extends IAbstractDAO<Resposta, Long> {
	
     void registrarRespostas(List<Resposta> respostas);
}