 
package br.com.questionario.repository.implementations;

import br.com.questionario.dao.generic.AbstractDAO;
import br.com.questionario.model.Pergunta;
import br.com.questionario.repository.interfaces.IPerguntaRepository;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
/**
 *
 * @author EudesSilva
 * 
 */
 

@Repository
public class PerguntaDAO extends AbstractDAO<Long, Pergunta> implements IPerguntaRepository{

    Logger logger = LoggerFactory.getLogger(PerguntaDAO.class);
     
     
     
   public void salvarPergunta(Pergunta pergunta) {
       persist(pergunta); 
   }
     
   public List<Pergunta> getAllPerguntasQuestionario(int idQuestionario){
    DetachedCriteria criteria = DetachedCriteria.forClass(Pergunta.class);
    criteria.add( Restrictions.eq("questionario.idQuestionario", idQuestionario));
    List<Pergunta> perguntas = getListCriteria(criteria); 
 
       for (Pergunta p : perguntas) {
           logger.info("Pergunta:::id"+p.getIdPergunta() );  
           logger.info("Pergunta:::Descricao"+p.getDescricaoPergunta() );  
       }
    
    return perguntas;
   }  
    
   public Pergunta findByIdPergunta(Long idPergunta){
      return findById(idPergunta);
   }
    
   public void deletePergunta(Pergunta pergunta){ 
      delete(pergunta);
   }

 
   
}
