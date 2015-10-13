 
package br.com.questionario.controller;

import br.com.questionario.model.Pergunta;
import br.com.questionario.model.Questionario;
import br.com.questionario.model.Usuario;
import br.com.questionario.servico.interfaces.IServicePergunta;
import br.com.questionario.servico.interfaces.IServiceQuestionario;
import br.com.questionario.util.MyLogger;
import java.util.List;
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
/**
 *
 * @author EudesSilva
 * 
 */

@RestController
public class QuestionarioController {
   
    private final MyLogger LOG = MyLogger.configLog(DestinatarioController.class);
     
    @Autowired
    private IServiceQuestionario serviceQuestionario;  
    @Autowired
    private IServicePergunta     servicePergunta;
 
   
    
    
    
    
    /*
      Os atributos das classes devem ser os mesmos quando utitlizar o angular
      na construção dos scripts. Detalhe ( LÁ É CASE SENSITIVE ) 
    */ 
    
    @RequestMapping(value = "/question/", method = RequestMethod.POST) //, UriComponentsBuilder builder
    public ResponseEntity<Integer> createQuestionario(@RequestBody Pergunta pergunta) {
   
        LOG.myLog("createQuestionario ::::::::::::::" );
        Usuario usu = new Usuario();
        usu.setIdUsuario(1); 
         
        if( serviceQuestionario == null ){
           LOG.myLog("serviceQuestionario is NULLL:::::::" ); 
        }else{
           LOG.myLog("servicePergunta OKKKKKK:::::::" );  
        }
        
        
        if( servicePergunta == null ){
           LOG.myLog("servicePergunta is NULLL:::::::" ); 
        }else{
           LOG.myLog("servicePergunta OKKKKKK:::::::" );  
        } 
        
        
        
        
        pergunta.getQuestionario().setUsuario(usu); 
        
        if( pergunta.getQuestionario().getIdQuestionario() == null ){ 
           LOG.myLog("ID Questionario VAZIO ::::::::::::::" ); 
           
           serviceQuestionario.saveQuestionario( pergunta.getQuestionario() );
           pergunta.setQuestionario( pergunta.getQuestionario() );
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
        
        LOG.myLog("deletePergunta PERGUNTA ID:::: " + idPergunta); 
        Pergunta pergunta = servicePergunta.findByIdPergunta(idPergunta); 
        if ( pergunta == null ) {
            LOG.myLog("ID Pergunta não existe::: " + idPergunta );
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
        
        servicePergunta.deletePergunta(pergunta);  
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
     
    
    
    @RequestMapping(value = "/question/{idQuestion}", method = RequestMethod.GET)
    public ResponseEntity<List<Pergunta>> listAllPerguntas(@PathVariable("idQuestion") int idQuestion) {
       
        LOG.myLog("listAllPerguntas ID QUESTION ::::::: " + idQuestion);
        List<Pergunta> perguntas = servicePergunta.getAllPerguntasQuestionario(idQuestion);
        
        for (Pergunta p : perguntas) {
           LOG.myLog("ID_Pergunta : " + p  ); 
           LOG.myLog("Descricao_Pergunta : " + p.getDescricaoPergunta() );
        }
        
        if( perguntas.isEmpty()){
            LOG.myLog("listAllPerguntas perguntas VAZIA ::::::: " + idQuestion);
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
