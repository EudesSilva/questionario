 
package br.com.questionario.repository.implementations;

import br.com.questionario.dao.generic.AbstractDAO;
import br.com.questionario.model.Gabarito;
import br.com.questionario.model.Pergunta;
import br.com.questionario.model.Resposta;
import br.com.questionario.repository.interfaces.IRespostaRepository;
import java.util.List;
import org.springframework.stereotype.Repository;
/**
 *
 * @author EudesSilva
 * 
 */
 

@Repository
public class RespostaDAO extends AbstractDAO<Long, Resposta> implements IRespostaRepository{

    
   public void registrarRespostas(List<Resposta> respostas){
        for (Resposta resposta : respostas) { 
            getSession().persist(resposta); 
            Gabarito gabarito = new Gabarito();
            gabarito.setPergunta( new Pergunta( resposta.getIdPergunta() ) );
            gabarito.setResposta(resposta);
            getSession().persist(gabarito);
       }
   }
   
}
