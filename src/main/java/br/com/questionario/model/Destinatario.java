package br.com.questionario.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Eudes Silva
 */
@Entity
@Table(name = "destinatario")
//@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
public class Destinatario implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDestinatario")
    private Integer idDestinatario; 
    @Column(name = "emailDestinatario") 
    private String emailDestinatario; 
    @Column(name = "respondido")  
    //@Type(type="yes_no")     //  more problems in types ... argggggg
    private boolean respondido;
 
    @OneToOne(fetch = javax.persistence.FetchType.EAGER)
    @JoinColumn(name = "idQuestionario",foreignKey = @ForeignKey(name="Destinatario_Questionario") )
  //  @JsonBackReference
    private Questionario questionario;
    
 
    public Integer getIdDestinatario() {
        return idDestinatario;
    }

    public void setIdDestinatario(Integer idDestinatario) {
        this.idDestinatario = idDestinatario;
    }

    public String getEmailDestinatario() {
        return emailDestinatario;
    }

    public void setEmailDestinatario(String emailDestinatario) {
        this.emailDestinatario = emailDestinatario;
    }

    public boolean isRespondido() {
        return respondido;
    }

    public void setRespondido(boolean respondido) {
        this.respondido = respondido;
    }
 
    public Questionario  getQuestionario() {
        return questionario;
    }

    public void setQuestionario(Questionario questionario) {
        this.questionario = questionario;
    } 
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDestinatario != null ? idDestinatario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Destinatario)) {
            return false;
        }
        Destinatario other = (Destinatario) object;
        if ((this.idDestinatario == null && other.idDestinatario != null) || (this.idDestinatario != null && !this.idDestinatario.equals(other.idDestinatario))) {
            return false;
        }
        return true;
    } 
    
    
    
    
    
}
