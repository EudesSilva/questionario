package br.com.questionario.controller;


import br.com.questionario.model.Destinatario;
import br.com.questionario.model.Pergunta;
import br.com.questionario.model.Resposta;
import br.com.questionario.servico.interfaces.IServiceDestinatario;
import br.com.questionario.servico.interfaces.IServiceResposta;
import br.com.questionario.util.MyLogger;
import java.util.List;
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
    
     
    private final MyLogger LOG = MyLogger.configLog(DestinatarioController.class);
    
    
    @Autowired
    private QuestionarioController questinarioController; 
    @Autowired
    private IServiceResposta     serviceResposta;   
    @Autowired
    private IServiceDestinatario serviceDestinatario;

    
    
    
    @RequestMapping(value = "/responde/", method = RequestMethod.POST )
    public ResponseEntity<Void> respostasQuestionario(@RequestBody List<Resposta> respostas) {
  
          
        for (Resposta rs : respostas) { 
            LOG.myLog("Resposta Class: "+ Resposta.class);
            LOG.myLog("ID: pergunta: " +  rs.getIdPergunta() );
            LOG.myLog("Resposta: " +  rs.getDescricaoResposta() );
            LOG.myLog("Alter 1 " +  rs.getDescricaoAlternativa1() );
            LOG.myLog("Resp Alter 1 " +  rs.getAlternativa1() ); 
            LOG.myLog("Alter 2 " +  rs.getDescricaoAlternativa2() );
            LOG.myLog("Resp Alter 2 " +  rs.getAlternativa2() ); 
            LOG.myLog("Alter 3 " +  rs.getDescricaoAlternativa3() );
            LOG.myLog("Resp Alter 3 " +  rs.getAlternativa3() );         
            LOG.myLog("Alter 4 " +  rs.getDescricaoAlternativa4() );
            LOG.myLog("Resp Alter 4 " +  rs.getAlternativa4() ); 
            LOG.myLog("Alter 5 " +  rs.getDescricaoAlternativa5() );
            LOG.myLog("Resp Alter 5 " +  rs.getAlternativa5() ); 
            LOG.myLog("Resp Tipo " +  rs.getTipoResposta() );  
        }
         
         if( respostas.isEmpty()){
             LOG.myLog("Resposta Vazia: " + Resposta.class);
           return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);//HttpStatus.NOT_FOUND
         } 
        for (Resposta resposta : respostas) { 
            LOG.myLog("respostas:::::: " + resposta.getDescricaoResposta()  ); 
         } 
        
         serviceResposta.registrarRespostas(respostas); 
          
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
    
    
    
    @RequestMapping(value = "/responde/registrar/", method = RequestMethod.PUT )
    public ResponseEntity<Void> registrarRespostaQuestionario(@RequestBody Destinatario destinatario) {
        
        LOG.myLog("Destinatario Registrar:: ");
        LOG.myLog("Destinatario Registrar:: " + destinatario.getEmailDestinatario() );
         
         serviceDestinatario.registrarRespostaQuestionario(destinatario);  
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
    
    
    
 
    @RequestMapping(value = "/responde/{emailDestino:.+}/{idQuestion}", method = RequestMethod.GET )
    public ResponseEntity<List<Pergunta>> perguntasQuestionario(@PathVariable("idQuestion") int idQuestion, @PathVariable("emailDestino") String emailDestino) { 
        
         LOG.myLog("::: idQuestion ::::::: " + idQuestion); 
         LOG.myLog("::: Email ::::::: " + emailDestino); 
        
        boolean validarResposta = serviceDestinatario.validarRespostaQuestionario(idQuestion, emailDestino);
        
        if( validarResposta ){
            LOG.myLog("Já RESPONDEU ESTE QUESTIONÁRIO:::::: ");
           return new ResponseEntity<List<Pergunta>>(HttpStatus.NO_CONTENT);//204 or -> HttpStatus.NOT_FOUND 404
          }  
        return questinarioController.listAllPerguntas(idQuestion);
    }
    
}
