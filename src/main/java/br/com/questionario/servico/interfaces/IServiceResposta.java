package br.com.questionario.servico.interfaces;
 
import br.com.questionario.model.Resposta;
import java.util.List;
/**
 *
 * @author EudesSilva
 * 
 */


public interface IServiceResposta {
       
    void registrarRespostas(List<Resposta> respostas); 
}
