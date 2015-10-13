package br.com.questionario.configuration;

import br.com.questionario.controller.DestinatarioController;
import br.com.questionario.model.AuthorityType;
import br.com.questionario.model.Usuario;
import br.com.questionario.servico.interfaces.IServiceUsuario;
import br.com.questionario.util.MyLogger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

 
 
@Component 
public class CustomUserDetailsService implements UserDetailsService{
 
    
    private final MyLogger LOG = MyLogger.configLog(CustomUserDetailsService.class);
    
    @Autowired 
    private IServiceUsuario serviceUsuario;
 
        
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Usuario user = serviceUsuario.findUserByEmail(userName);

        if(user == null){
                throw new UsernameNotFoundException("UserName "+userName+" not found");
        }

    UserDetails userDetails = new org.springframework.security.core.userdetails
                                   .User( user.getEmail(), user.getPassword(),
                                    user.isEnabled(), user.isAccountNonExpired(),
                                    user.isCredentialsNonExpired(), user.isAccountNonLocked(),
                                    getAuthorities(user) );


        LOG.myLog("UserDetails " + user.getEmail() +"  ::  "+ user.getPassword() );
        return userDetails; 
    }

 	 
    public Collection<? extends GrantedAuthority> getAuthorities(Usuario user) {

        Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        Set<AuthorityType> userAuths = user.getAuthorityTypeList();

        if (userAuths != null) {
            for (AuthorityType auth : userAuths) {
                LOG.myLog("ROLE___ " + auth.getauthorityTypeName() );
                SimpleGrantedAuthority authority = new SimpleGrantedAuthority(auth.getauthorityTypeName());
                authorities.add(authority);
            }
        }
        return authorities;
    }

	    
        
        
        
        
}
