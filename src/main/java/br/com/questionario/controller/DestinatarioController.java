package br.com.questionario.controller;


import br.com.questionario.model.Destinatario;
import br.com.questionario.model.Pergunta;
import br.com.questionario.model.Resposta;
import br.com.questionario.servico.implementations.ServiceDestinatario;
import br.com.questionario.servico.interfaces.IServiceDestinatario;
import br.com.questionario.servico.interfaces.IServicePergunta;
import br.com.questionario.servico.interfaces.IServiceResposta;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
/**
 *
 * @author EudesSilva
 * 
 */
 

@RestController
public class DestinatarioController {
    
    Logger logger = LoggerFactory.getLogger(DestinatarioController.class);
 
    @Autowired
    private QuestionarioController questinarioController;
    
    @Autowired
    IServiceResposta serviceResposta;
    
    @Autowired
    IServicePergunta servicePergunta ;
    
    @Autowired
    IServiceDestinatario serviceDestinatario;

    
    
    
    @RequestMapping(value = "/responde/", method = RequestMethod.POST )
    public ResponseEntity<Void> respostasQuestionario(@RequestBody List<Resposta> respostas) {
 
          
        for (Resposta rs : respostas) { 
            logger.info("Resposta Class: ", Resposta.class);
            logger.info("ID: pergunta: " +  rs.getIdPergunta() );
            logger.info("Resposta: " +  rs.getDescricaoResposta() );
            logger.info("Alter 1 " +  rs.getDescricaoAlternativa1() );
            logger.info("Resp Alter 1 " +  rs.getAlternativa1() ); 
            logger.info("Alter 2 " +  rs.getDescricaoAlternativa2() );
            logger.info("Resp Alter 2 " +  rs.getAlternativa2() ); 
            logger.info("Alter 3 " +  rs.getDescricaoAlternativa3() );
            logger.info("Resp Alter 3 " +  rs.getAlternativa3() );         
            logger.info("Alter 4 " +  rs.getDescricaoAlternativa4() );
            logger.info("Resp Alter 4 " +  rs.getAlternativa4() ); 
            logger.info("Alter 5 " +  rs.getDescricaoAlternativa5() );
            logger.info("Resp Alter 5 " +  rs.getAlternativa5() ); 
            logger.info("Resp Tipo " +  rs.getTipoResposta() );  
        }
         
         if( respostas.isEmpty()){
             logger.info("Resposta Vazia: ", Resposta.class);
           return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);//HttpStatus.NOT_FOUND
         } 
        for (Resposta resposta : respostas) { 
            logger.info("respostas:::::: " + resposta.getDescricaoResposta()  ); 
         } 
        
         serviceResposta.registrarRespostas(respostas); 
          
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
    
    
    
    @RequestMapping(value = "/responde/registrar/", method = RequestMethod.PUT )
    public ResponseEntity<Void> registrarRespostaQuestionario(@RequestBody Destinatario destinatario) {
        
        logger.info("Destinatario Registrar:: ");
        logger.info("Destinatario Registrar:: " , destinatario.getEmailDestinatario() );
         
         serviceDestinatario.registrarRespostaQuestionario(destinatario);  
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
    
    
    
 
    @RequestMapping(value = "/responde/{emailDestino:.+}/{idQuestion}", method = RequestMethod.GET )
    public ResponseEntity<List<Pergunta>> perguntasQuestionario(@PathVariable("idQuestion") int idQuestion, @PathVariable("emailDestino") String emailDestino) { 
        
         logger.info("::: idQuestion ::::::: " + idQuestion); 
         logger.info("::: Email ::::::: " + emailDestino); 
        
        boolean validarResposta = serviceDestinatario.validarRespostaQuestionario(idQuestion, emailDestino);
        
        if( validarResposta ){
            logger.info("Já RESPONDEU ESTE QUESTIONÁRIO:::::: ");
           return new ResponseEntity<List<Pergunta>>(HttpStatus.NO_CONTENT);//204 or -> HttpStatus.NOT_FOUND 404
          }  
        return questinarioController.listAllPerguntas(idQuestion);
    }
    
}
