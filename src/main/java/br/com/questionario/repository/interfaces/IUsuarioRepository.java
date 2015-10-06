package br.com.questionario.repository.interfaces;

 
import br.com.questionario.dao.generic.IAbstractDAO; 
import br.com.questionario.model.Usuario; 
/**
 *
 * @author EudesSilva
 * 
 */
 

public interface IUsuarioRepository extends IAbstractDAO<Usuario, Long> {
	
    //we inherit the basic CRUD operations from the GenericRepository
 

     void saveUsuario(Usuario usuario); 
     
     
}