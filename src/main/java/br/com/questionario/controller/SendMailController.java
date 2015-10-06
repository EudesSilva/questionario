package br.com.questionario.controller;

import br.com.questionario.model.Questionario;
import br.com.questionario.servico.interfaces.IServiceDestinatario;
import br.com.questionario.servico.interfaces.IServiceQuestionario;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController; 
/**
 *
 * @author EudesSilva
 * 
 */
@RestController
public class SendMailController {
  
    Logger logger = LoggerFactory.getLogger(SendMailController.class);
  
  
    @Autowired 
    IServiceQuestionario serviceQuestionario;
    
    @Autowired
    IServiceDestinatario serviceDestinatario;
 
    
    
    @RequestMapping(value = "/sendmail/{idUser}", method = RequestMethod.GET)
    public ResponseEntity<List<Questionario>> listAllQuestionarios(@PathVariable("idUser") int idUser) {
       
        logger.info(":::listAllQuestionarios ID idUser::::::: " + idUser); 
        List<Questionario> questionarios =  serviceQuestionario.listarQuestionariosUsuario(idUser);
 
        if( questionarios.isEmpty()){
            logger.info("questionarios VAZIO ::::::::::::::" );
            return new ResponseEntity<List<Questionario>>(HttpStatus.NO_CONTENT);//HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Questionario>>(questionarios, HttpStatus.OK);
    }
    
 
    
      // Problems in Suffix Pattern add regex ( slice dot in string )
     //:.+
        
    @RequestMapping(value = "/sendmail/{idQuestion}/{emailDestino:.+}", method = RequestMethod.GET)
    public ResponseEntity<Void> sendEmailQuestionario(@PathVariable("idQuestion") int idQuestion, @PathVariable("emailDestino") String emailDestino) {
       
       logger.info("sendEmailQuestionario:   EMAIL::: " + emailDestino + "  idQuestion:: " + idQuestion);
       serviceDestinatario.enviarQuestionario(idQuestion, emailDestino); 

      return new ResponseEntity<Void>( HttpStatus.OK ); 
    }
    
    
    
    
    
}
