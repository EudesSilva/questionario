package br.com.questionario.controller;
 
 
import br.com.questionario.model.Questionario;
import br.com.questionario.servico.interfaces.IServiceDestinatario;
import br.com.questionario.servico.interfaces.IServiceQuestionario;
import br.com.questionario.util.MyLogger;
import java.util.List;
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
  
    
    private final MyLogger LOG = MyLogger.configLog(DestinatarioController.class);
    
    @Autowired
    private IServiceQuestionario serviceQuestionario; 
    @Autowired
    private IServiceDestinatario serviceDestinatario;
 
 
    
    @RequestMapping(value = "/sendmail/{idUser}", method = RequestMethod.GET)
    public ResponseEntity<List<Questionario>> listAllQuestionarios(@PathVariable("idUser") int idUser) {
       
        LOG.myLog(":::listAllQuestionarios ID idUser::::::: " + idUser); 
        List<Questionario> questionarios =  serviceQuestionario.listarQuestionariosUsuario(idUser);
 
        if( questionarios.isEmpty()){
            LOG.myLog("questionarios VAZIO ::::::::::::::" );
            return new ResponseEntity<List<Questionario>>(HttpStatus.NO_CONTENT);//HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Questionario>>(questionarios, HttpStatus.OK);
    }
    
 
    
      // Problems in Suffix Pattern add regex ( slice dot in string )
     //:.+
        
    @RequestMapping(value = "/sendmail/{idQuestion}/{emailDestino:.+}", method = RequestMethod.GET)
    public ResponseEntity<Void> sendEmailQuestionario(@PathVariable("idQuestion") int idQuestion, @PathVariable("emailDestino") String emailDestino) {
       
       LOG.myLog("sendEmailQuestionario:   EMAIL::: " + emailDestino + "  idQuestion:: " + idQuestion);
       serviceDestinatario.enviarQuestionario(idQuestion, emailDestino); 

      return new ResponseEntity<Void>( HttpStatus.OK ); 
    }
    
    
    
    
    
}
