package br.com.questionario.servico.interfaces;

import br.com.questionario.model.Pergunta;
import java.util.List;
/**
 *
 * @author EudesSilva
 * 
 */ 
 
public interface IServicePergunta {
    
    
    void savePergunta( Pergunta pergunta );
    Pergunta findByIdPergunta(Long idPergunta);
    void deletePergunta(Pergunta pergunta);
    List<Pergunta> getAllPerguntasQuestionario(int idQuestionario);
    
    
}
