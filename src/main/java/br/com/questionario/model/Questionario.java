package br.com.questionario.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Eudes Silva
 */
@Entity
@Table(name = "questionario")  
public class Questionario implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
  //  @Basic(optional = false)
    @Column(name = "idQuestionario")
    private Integer idQuestionario;
    
    @Column(name = "tituloQuestionario",length = 80)
    private String tituloQuestionario;
    
    
    // solved the famous LazyInitializationException:  -> using FetchType.EAGER   :)
    //@JsonManagedReference
    @JsonIgnore 
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "questionario", fetch = FetchType.EAGER)  // comentar
    private Set<Pergunta> perguntaList= new HashSet<Pergunta>();
 
    
    @JoinColumn(name = "idUsuario")//, foreignKey = @ForeignKey(name="Questionario_Usuario")) 
    @ManyToOne(optional = false)//, fetch = FetchType.EAGER) 
    @JsonIgnore
    private Usuario usuario;
    

    public Questionario() { 
    }
 

    public Questionario(Integer idQuestionario) {
        this.idQuestionario = idQuestionario;
    }

    public Integer getIdQuestionario() {
        return idQuestionario;
    }

    public void setIdQuestionario(Integer idQuestionario) {
        this.idQuestionario = idQuestionario;
    }

    public String getTituloQuestionario() {
        return tituloQuestionario;
    }

    public void setTituloQuestionario(String tituloQuestionario) {
        this.tituloQuestionario = tituloQuestionario;
    }

    public Set<Pergunta> getPerguntaList() {
        return perguntaList;
    }

    public void setPerguntaList(Set<Pergunta> perguntaList) {
        this.perguntaList = perguntaList;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idQuestionario != null ? idQuestionario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Questionario)) {
            return false;
        }
        Questionario other = (Questionario) object;
        if ((this.idQuestionario == null && other.idQuestionario != null) || (this.idQuestionario != null && !this.idQuestionario.equals(other.idQuestionario))) {
            return false;
        }
        return true;
    }

}
