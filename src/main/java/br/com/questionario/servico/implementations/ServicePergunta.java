package br.com.questionario.servico.implementations;

import br.com.questionario.model.Pergunta;
import br.com.questionario.repository.implementations.PerguntaDAO;
import br.com.questionario.servico.interfaces.IServicePergunta;
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
public class ServicePergunta implements IServicePergunta{

    @Autowired
    PerguntaDAO perguntaDAO;
    
    public Pergunta findByIdPergunta(Long idPergunta){
        return perguntaDAO.findByIdPergunta(idPergunta);
    }
    
   // @Transactional(readOnly = false, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT )
    public void deletePergunta(Pergunta pergunta){
        perguntaDAO.deletePergunta(pergunta);
    }
    
   // @Transactional(readOnly = false, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT )
    public void savePergunta(Pergunta pergunta) {
        perguntaDAO.saveOrUpdate(pergunta);
    }
    
    public List<Pergunta> getAllPerguntasQuestionario(int idQuestionario){
        return perguntaDAO.getAllPerguntasQuestionario(idQuestionario);
    }
    
    
}
