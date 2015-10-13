package br.com.questionario.servico.implementations;

import br.com.questionario.model.Usuario;
import br.com.questionario.repository.implementations.UsuarioDAO;
import br.com.questionario.servico.interfaces.IServiceUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
 *
 * @author EudesSilva
 * 
 */
@Service
@Transactional//(readOnly = true)
public class ServiceUsuario implements IServiceUsuario{
    
 
    @Autowired 
    private UsuarioDAO usuarioDAO;
    
    public Usuario findUserByEmail(String email) {
            return usuarioDAO.findByEmailUser(email);
    }
    
    
    
    
    
    
    
    
    //@Transactional(readOnly = false, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT )
//    public void saveUsuario( Usuario usuario ){
//        usuarioDAO.saveUsuario(usuario); 
//    }

//    public UserDetails loadUserByUsername(String email) {
//        Usuario user = usuarioDAO.findByEmailUser(email);
//        if( user == null ){
//              throw new UsernameNotFoundException("username " + email  + " not found");
//        }
//	List<GrantedAuthority> authorities = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER");
//      // / if (email.equals("admin")) {
//      //          authorities = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_ADMIN");
//      //  } 
//        
//      String password = user.getPassword();
//     return new org.springframework.security.core.userdetails.User(email, password, authorities);
//    }

   

    
    
}
