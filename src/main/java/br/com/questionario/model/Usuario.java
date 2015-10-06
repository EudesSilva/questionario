package br.com.questionario.model;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity; 
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id; 
import javax.persistence.OneToMany;
import javax.persistence.Table; 
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 *
 * @author Eudes Silva
 */
@Entity
@Table(name = "usuario")
//@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
public class Usuario implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idUsuario")
    private Integer idUsuario; 
    @Column(name = "nome")
    private String nome; 
    
   // @LazyCollection(LazyCollectionOption.FALSE)
    //@OneToMany(cascade = CascadeType.ALL)//, fetch = FetchType.EAGER )//mappedBy = "usuario", )
   // @JsonManagedReference  
    //@Fetch(value = FetchMode.SUBSELECT)
    @OneToMany(mappedBy="usuario", cascade= CascadeType.ALL, fetch = FetchType.EAGER )  
    //@LazyCollection(LazyCollectionOption.FALSE) 
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

    public Set<Questionario> getQuestionarioList() {
        return questionarioList;
    }

    public void setQuestionarioList(Set<Questionario> questionarioList) {
        this.questionarioList = questionarioList;
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
