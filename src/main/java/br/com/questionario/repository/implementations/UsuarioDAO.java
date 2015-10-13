package br.com.questionario.repository.implementations;

import br.com.questionario.dao.generic.AbstractDAO;
import br.com.questionario.model.Usuario;
import br.com.questionario.repository.interfaces.IUsuarioRepository; 
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository; 
/**
 *
 * @author EudesSilva
 * 
 */


@Repository
public class UsuarioDAO extends AbstractDAO<Long, Usuario> implements IUsuarioRepository{
 
   
    // metodo especifico da classe concreta..
   public void specifiedRule(String s){
       System.out.println("My Rule");
   }
   
   public Usuario findByEmailUser( String email ){
     DetachedCriteria criteria = DetachedCriteria.forClass(Usuario.class);
     criteria.add( Restrictions.eq("email", email)); 
     Usuario usuario = getUnique(criteria);
     return usuario;
   }
   
 
 
    public void criarUsuario(String username, String email, String password) {
        ShaPasswordEncoder encoder = new ShaPasswordEncoder();
        Usuario usuario = new Usuario(); 
        usuario.setPassword( encoder.encodePassword(password, "salt")); 
        persist(usuario); 
    }
    
    
    
    
    
    
    
  
   
   
}