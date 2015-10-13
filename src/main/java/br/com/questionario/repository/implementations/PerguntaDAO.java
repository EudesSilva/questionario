 
package br.com.questionario.repository.implementations;

import br.com.questionario.dao.generic.AbstractDAO;
import br.com.questionario.model.Pergunta;
import br.com.questionario.repository.interfaces.IPerguntaRepository;
import br.com.questionario.util.MyLogger;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
/**
 *
 * @author EudesSilva
 * 
 */
 

@Repository
public class PerguntaDAO extends AbstractDAO<Long, Pergunta> implements IPerguntaRepository{

 
    private final MyLogger LOG = MyLogger.configLog(PerguntaDAO.class);
     
     
   public void salvarPergunta(Pergunta pergunta) {
       persist(pergunta); 
   }
     
   public List<Pergunta> getAllPerguntasQuestionario(int idQuestionario){
    DetachedCriteria criteria = DetachedCriteria.forClass(Pergunta.class);
    criteria.add( Restrictions.eq("questionario.idQuestionario", idQuestionario));
    List<Pergunta> perguntas = getListCriteria(criteria); 
 
       for (Pergunta p : perguntas) {
           LOG.myLog("Pergunta:::id"+p.getIdPergunta() );  
           LOG.myLog("Pergunta:::Descricao"+p.getDescricaoPergunta() );  
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
