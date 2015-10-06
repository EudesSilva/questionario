package br.com.questionario.repository.implementations;

import br.com.questionario.dao.generic.AbstractDAO;
import br.com.questionario.model.Usuario;
import br.com.questionario.repository.interfaces.IUsuarioRepository; 
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
   
   
   @Override
    public void saveUsuario(Usuario usuario) {
         persist(usuario); 
    }


  
   
   
}