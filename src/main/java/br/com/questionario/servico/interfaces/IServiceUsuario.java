package br.com.questionario.servico.interfaces;

import br.com.questionario.model.Usuario;
 
/**
 *
 * @author EudesSilva
 * 
 */

public interface IServiceUsuario{
     
 
    Usuario findUserByEmail(String email);
    
}
