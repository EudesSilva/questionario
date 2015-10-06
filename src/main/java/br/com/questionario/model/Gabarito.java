 package br.com.questionario.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne; 
import javax.persistence.Table;

/**
 *
 * @author EudesSilva
 * 
 */
@Entity
@Table(name = "gabarito") 
//@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@idGabarito")
public class Gabarito implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idGabarito")
    private Long idGabarito;
    
    //@JsonIgnore
   // @JsonBackReference
    @JoinColumn(name = "idPergunta", foreignKey = @ForeignKey(name="Gabarito_Pergunta"))//, referencedColumnName = "idPergunta")
    @ManyToOne(optional = false )//, fetch = FetchType.EAGER)
    private Pergunta pergunta;
    
    
    @JoinColumn(name = "idResposta", referencedColumnName = "idResposta",foreignKey = @ForeignKey(name="Gabarito_Resposta"))
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Resposta resposta;

    public Gabarito() {
    }

    public Gabarito(Long idGabarito) {
        this.idGabarito = idGabarito;
    }

    public Long getIdGabarito() {
        return idGabarito;
    }

    public void setIdGabarito(Long idGabarito) {
        this.idGabarito = idGabarito;
    }

    public Pergunta getPergunta() {
        return pergunta;
    }

    public void setPergunta(Pergunta pergunta) {
        this.pergunta = pergunta;
    }

    public Resposta getResposta() {
        return resposta;
    }

    public void setResposta(Resposta resposta) {
        this.resposta = resposta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGabarito != null ? idGabarito.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Gabarito)) {
            return false;
        }
        Gabarito other = (Gabarito) object;
        if ((this.idGabarito == null && other.idGabarito != null) || (this.idGabarito != null && !this.idGabarito.equals(other.idGabarito))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "generator.Gabarito[ idGabarito=" + idGabarito + " ]";
    }
    
}
