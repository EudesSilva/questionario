 

package br.com.questionario.factory;

import br.com.questionario.servico.interfaces.IServiceDestinatario;
import br.com.questionario.servico.interfaces.IServicePergunta;
import br.com.questionario.servico.interfaces.IServiceQuestionario;
import br.com.questionario.servico.interfaces.IServiceResposta;
import br.com.questionario.servico.interfaces.IServiceUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author EudesSilva
 * 
 */

@Component
public class Factory {
    
 
    private static IServiceQuestionario serviceQuestionario;  
    private static IServiceDestinatario serviceDestinatario;
    private static IServicePergunta     servicePergunta;
    private static IServiceResposta     serviceResposta;
    private static IServiceUsuario      serviceUsuario;
    
    
    
    @Autowired 
    public Factory(IServiceQuestionario serviceQuestionario, IServiceDestinatario serviceDestinatario,
                   IServicePergunta servicePergunta, IServiceResposta serviceResposta,
                   IServiceUsuario serviceUsuario) {
        Factory.serviceQuestionario = serviceQuestionario;
        Factory.serviceDestinatario = serviceDestinatario;
        Factory.servicePergunta = servicePergunta;
        Factory.serviceResposta = serviceResposta;
        Factory.serviceUsuario = serviceUsuario;
    }

    
    
    
    
    
    
    
    public static IServiceQuestionario getServiceQuestionario() {
        return serviceQuestionario;
    }

    public static IServiceDestinatario getServiceDestinatario() {
        return serviceDestinatario;
    }

    public static IServicePergunta getServicePergunta() {
        return servicePergunta;
    }

    public static IServiceResposta getServiceResposta() {
        return serviceResposta;
    }

    public static IServiceUsuario getServiceUsuario() {
        return serviceUsuario;
    }
    

    
    
    
 

   
    

  
 
  
  
  
}