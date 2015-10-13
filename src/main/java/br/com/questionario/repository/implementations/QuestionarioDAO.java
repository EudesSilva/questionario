 
package br.com.questionario.repository.implementations;

import br.com.questionario.dao.generic.AbstractDAO;
import br.com.questionario.model.Questionario;
import br.com.questionario.repository.interfaces.IQuestionarioRepository;
import br.com.questionario.util.MyLogger;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
/**
 *
 * @author EudesSilva
 * 
 */

@Repository
public class QuestionarioDAO extends AbstractDAO<Long, Questionario> implements IQuestionarioRepository{
 
  
    private final MyLogger LOG = MyLogger.configLog(QuestionarioDAO.class);
    
    
    
    
    
    public void saveQuestionario(Questionario questionario) { 
         persist(questionario);
    }
    
    
   public List<Questionario> listarQuestionarios(int idUser){
    DetachedCriteria criteria = DetachedCriteria.forClass(Questionario.class);
    criteria.add( Restrictions.eq("usuario.idUsuario", idUser));
    criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);     // dores de cabeça aliviadas...............
    List<Questionario> questionarios =  criteria.getExecutableCriteria(getSession()).list();
    
       for (Questionario q : questionarios) {
           LOG.myLog("Questionario::::::::: " + q.getIdQuestionario() ); 
           LOG.myLog("Questionario::::::::: " + q.getTituloQuestionario() ); 
       }
    return questionarios;   
   }
   
}
