package br.com.questionario.servico.implementations;

import br.com.questionario.model.Usuario;
import br.com.questionario.repository.implementations.UsuarioDAO;
import br.com.questionario.servico.interfaces.IServiceUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
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
    
    //@Transactional(readOnly = false, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT )
    public void saveUsuario( Usuario usuario ){
        usuarioDAO.saveUsuario(usuario); 
    }

    
    
}
