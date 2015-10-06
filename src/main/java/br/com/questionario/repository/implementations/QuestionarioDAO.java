 
package br.com.questionario.repository.implementations;

import br.com.questionario.dao.generic.AbstractDAO;
import br.com.questionario.model.Questionario;
import br.com.questionario.repository.interfaces.IQuestionarioRepository;
import java.util.List;
import org.hibernate.Criteria;
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
public class QuestionarioDAO extends AbstractDAO<Long, Questionario> implements IQuestionarioRepository{
 
    Logger logger = LoggerFactory.getLogger(QuestionarioDAO.class);
    
    public void saveQuestionario(Questionario questionario) {
        persist(questionario);
    }
    
    
   public List<Questionario> listarQuestionarios(int idUser){
    DetachedCriteria criteria = DetachedCriteria.forClass(Questionario.class);
    criteria.add( Restrictions.eq("usuario.idUsuario", idUser));
    criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);     // dores de cabeça aliviadas...............
    List<Questionario> questionarios =  criteria.getExecutableCriteria(getSession()).list();
    
       for (Questionario q : questionarios) {
           logger.info("Questionario::::::::: " + q.getIdQuestionario() ); 
           logger.info("Questionario:::::::::::: " + q.getTituloQuestionario() ); 
       }
    return questionarios;   
   }
   
}
