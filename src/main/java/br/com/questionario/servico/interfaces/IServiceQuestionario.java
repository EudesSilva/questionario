 
package br.com.questionario.servico.interfaces;

import br.com.questionario.model.Questionario;
import java.util.List;
/**
 *
 * @author EudesSilva
 * 
 */
 
public interface IServiceQuestionario {
   
    
    void saveQuestionario( Questionario questionario );
    public List<Questionario> listarQuestionariosUsuario(int idUser); 
}
