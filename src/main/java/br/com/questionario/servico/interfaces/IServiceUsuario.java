package br.com.questionario.servico.interfaces;

import br.com.questionario.model.Usuario;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
 
/**
 *
 * @author EudesSilva
 * 
 */

public interface IServiceUsuario{
     
///    void saveUsuario( Usuario usuario );

   // public UserDetails loadUserByUsername(String string) throws UsernameNotFoundException;
    Usuario findUserByEmail(String email);
    
}
