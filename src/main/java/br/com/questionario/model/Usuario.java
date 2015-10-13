package br.com.questionario.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity; 
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id; 
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table; 

/**
 *
 * @author Eudes Silva
 */
@Entity
@Table(name = "usuario") 
public class Usuario implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idUsuario")
    private Integer idUsuario; 
    @Column(name = "nome")
    private String nome; 
    @Column(name="email")
    private String email;
    @Column(name="password")
    private String password;
 
    private boolean accountNonExpired;
    private boolean accountNonLocked;   
    private boolean credentialsNonExpired;
    private boolean enabled;
    
    @OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name="user_id")
    private Set<AuthorityType> authorityTypeList = new HashSet<AuthorityType>();
    
    
    
   // @LazyCollection(LazyCollectionOption.FALSE)
    //@OneToMany(cascade = CascadeType.ALL)//, fetch = FetchType.EAGER )//mappedBy = "usuario", )
   // @JsonManagedReference  
    //@Fetch(value = FetchMode.SUBSELECT)
    //@LazyCollection(LazyCollectionOption.FALSE) 
    @OneToMany(mappedBy="usuario", cascade= CascadeType.ALL, fetch = FetchType.EAGER )   
    private Set<Questionario> questionarioList;
  
    
    public Usuario() {
    }

    public Usuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Set<Questionario> getQuestionarioList() {
        return questionarioList;
    }

    public void setQuestionarioList(Set<Questionario> questionarioList) {
        this.questionarioList = questionarioList;
    }

    public Set<AuthorityType> getAuthorityTypeList() {
        return authorityTypeList;
    }

    public void setAuthorityTypeList(Set<AuthorityType> authorityTypeList) {
        this.authorityTypeList = authorityTypeList;
    }
 

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    
}
