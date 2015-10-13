package br.com.questionario.servico.implementations;

import br.com.questionario.model.Resposta;
import br.com.questionario.repository.implementations.RespostaDAO;
import br.com.questionario.servico.interfaces.IServiceResposta;
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
public class ServiceResposta implements IServiceResposta{
  
     // it details some of the semantics regarding transaction propagation in Spring.
    //http://docs.spring.io/spring/docs/3.1.x/spring-framework-reference/html/transaction.html#tx-propagation
 
   @Autowired 
   private RespostaDAO respostaDAO;
    
 
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT )
   public void registrarRespostas(List<Resposta> respostas){
      respostaDAO.registrarRespostas(respostas);
   } 
    
}
