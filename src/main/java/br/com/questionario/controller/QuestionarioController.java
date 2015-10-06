 
package br.com.questionario.controller;

import br.com.questionario.model.Pergunta;
import br.com.questionario.model.Questionario;
import br.com.questionario.model.Usuario;
import br.com.questionario.servico.interfaces.IServicePergunta;
import br.com.questionario.servico.interfaces.IServiceQuestionario;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity; 
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
/**
 *
 * @author EudesSilva
 * 
 */

@RestController
public class QuestionarioController {
    
    Logger logger = LoggerFactory.getLogger(QuestionarioController.class);
    
   
    
    @Autowired
    IServiceQuestionario serviceQuestionario;
    
    @Autowired
    IServicePergunta servicePergunta;
 
    
    /*
      Os atributos das classes devem ser os mesmos quando utitlizar o angular
      na construção dos scripts. Detalhe ( LÁ É CASE SENSITIVE ) 
    */ 
    
    @RequestMapping(value = "/question/", method = RequestMethod.POST)
    public ResponseEntity<Integer> createQuestionario(@RequestBody Pergunta pergunta, UriComponentsBuilder builder) {
 
        logger.info("createQuestionario ::::::::::::::" );
        Usuario usu = new Usuario();
        usu.setIdUsuario(1);
        usu.setNome("FAKE USER");  
        
        pergunta.getQuestionario().setUsuario(usu);
  
        if( pergunta.getQuestionario().getIdQuestionario() == null ){ 
           logger.info("ID Questionario VAZIO ::::::::::::::" );
          serviceQuestionario.saveQuestionario( pergunta.getQuestionario() );  
        }  
        servicePergunta.savePergunta(pergunta);  
        Questionario qresposta = pergunta.getQuestionario();

        // HttpHeaders headers = new HttpHeaders();
        // headers.setLocation( builder.path("/question/{id}").buildAndExpand( qresposta.getIdQuestionario() ).toUri() );
        Integer IdQuestionario = qresposta.getIdQuestionario();
        return new ResponseEntity<Integer>( IdQuestionario, HttpStatus.CREATED ); 
    }
    
 
    @RequestMapping(value = "/question/{idPergunta}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deletePergunta(@PathVariable("idPergunta") Long idPergunta) {
        
        logger.info("deletePergunta PERGUNTA ID:::: " + idPergunta); 
        Pergunta pergunta = servicePergunta.findByIdPergunta(idPergunta); 
        if ( pergunta == null ) {
            logger.info("ID Pergunta não existe::: " + idPergunta );
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
        
        servicePergunta.deletePergunta(pergunta);  
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
     
    
    
    @RequestMapping(value = "/question/{idQuestion}", method = RequestMethod.GET)
    public ResponseEntity<List<Pergunta>> listAllPerguntas(@PathVariable("idQuestion") int idQuestion) {
       
        logger.info("listAllPerguntas ID QUESTION ::::::: " + idQuestion);
        List<Pergunta> perguntas = servicePergunta.getAllPerguntasQuestionario(idQuestion);
        
        for (Pergunta p : perguntas) {
           logger.info("ID_Pergunta : " , p  ); 
           logger.info("Descricao_Pergunta : " + p.getDescricaoPergunta() );
        }
        
        if( perguntas.isEmpty()){
            logger.info("listAllPerguntas perguntas VAZIA ::::::: " + idQuestion);
            return new ResponseEntity<List<Pergunta>>(HttpStatus.NO_CONTENT);//HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Pergunta>>(perguntas, HttpStatus.OK);
    }
    
     
    
    // Helps
    //http://www.leveluplunch.com/java/tutorials/014-post-json-to-spring-rest-webservice/
    
 
    
	private String getPrincipal(){
		String userName = "";
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			userName = ((UserDetails)principal).getUsername();
		} else {
			userName = principal.toString();
		}
		return userName;
	}  
    
    
}
