 package br.com.questionario.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
import javax.persistence.Transient;

/**
 *
 * @author EudesSilva
 * 
 */
@Entity
@Table(name = "resposta") 
//@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
public class Resposta implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idResposta")
    private Long idResposta;
    @Column(name = "descricaoResposta")
    private String descricaoResposta;
    @Column(name = "alternativa1")
    private Boolean alternativa1;
    @Column(name = "alternativa2")
    private Boolean alternativa2;
    @Column(name = "alternativa3")
    private Boolean alternativa3;
    @Column(name = "alternativa4")
    private Boolean alternativa4;
    @Column(name = "alternativa5")
    private Boolean alternativa5; 
    @Basic(optional = false)
    @Column(name = "tipoResposta") 
    private boolean tipoResposta;
    @Column(name = "descricaoAlternativa1",length = 80)
    private String descricaoAlternativa1;
    @Column(name = "descricaoAlternativa2",length = 80)
    private String descricaoAlternativa2;
    @Column(name = "descricaoAlternativa3",length = 80)
    private String descricaoAlternativa3;
    @Column(name = "descricaoAlternativa4",length = 80)
    private String descricaoAlternativa4;
    @Column(name = "descricaoAlternativa5",length = 80)
    private String descricaoAlternativa5; 
    @Transient
    private Long idPergunta; 
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "resposta", fetch = FetchType.EAGER)
    @JsonManagedReference 
    @JsonIgnore
    private Set<Gabarito> gabaritoList;
 
    public Resposta() {
    }

    public Resposta(Long idResposta) {
        this.idResposta = idResposta;
    }

    public String getDescricaoAlternativa1() {
        return descricaoAlternativa1;
    }

    public void setDescricaoAlternativa1(String descricaoAlternativa1) {
        this.descricaoAlternativa1 = descricaoAlternativa1;
    }

    public String getDescricaoAlternativa2() {
        return descricaoAlternativa2;
    }

    public void setDescricaoAlternativa2(String descricaoAlternativa2) {
        this.descricaoAlternativa2 = descricaoAlternativa2;
    }

    public String getDescricaoAlternativa3() {
        return descricaoAlternativa3;
    }

    public void setDescricaoAlternativa3(String descricaoAlternativa3) {
        this.descricaoAlternativa3 = descricaoAlternativa3;
    }

    public String getDescricaoAlternativa4() {
        return descricaoAlternativa4;
    }

    public void setDescricaoAlternativa4(String descricaoAlternativa4) {
        this.descricaoAlternativa4 = descricaoAlternativa4;
    }

    public String getDescricaoAlternativa5() {
        return descricaoAlternativa5;
    }

    public void setDescricaoAlternativa5(String descricaoAlternativa5) {
        this.descricaoAlternativa5 = descricaoAlternativa5;
    }

    public boolean isTipoResposta() {
        return tipoResposta;
    }
     public boolean getTipoResposta() {
        return tipoResposta;
    }
    public void setTipoResposta(boolean tipoResposta) {
        this.tipoResposta = tipoResposta;
    }
 
    public Long getIdPergunta() {
        return idPergunta;
    }

    public void setIdPergunta(Long idPergunta) {
        this.idPergunta = idPergunta;
    }
 
    
    public Long getIdResposta() {
        return idResposta;
    }

    public void setIdResposta(Long idResposta) {
        this.idResposta = idResposta;
    }

    public String getDescricaoResposta() {
        return descricaoResposta;
    }

    public void setDescricaoResposta(String descricaoResposta) {
        this.descricaoResposta = descricaoResposta;
    }

    public Boolean getAlternativa1() {
        return alternativa1;
    }

    public void setAlternativa1(Boolean alternativa1) {
        this.alternativa1 = alternativa1;
    }

    public Boolean getAlternativa2() {
        return alternativa2;
    }

    public void setAlternativa2(Boolean alternativa2) {
        this.alternativa2 = alternativa2;
    }

    public Boolean getAlternativa3() {
        return alternativa3;
    }

    public void setAlternativa3(Boolean alternativa3) {
        this.alternativa3 = alternativa3;
    }

    public Boolean getAlternativa4() {
        return alternativa4;
    }

    public void setAlternativa4(Boolean alternativa4) {
        this.alternativa4 = alternativa4;
    }

    public Boolean getAlternativa5() {
        return alternativa5;
    }

    public void setAlternativa5(Boolean alternativa5) {
        this.alternativa5 = alternativa5;
    }

    public Set<Gabarito> getGabaritoList() {
        return gabaritoList;
    }

    public void setGabaritoList(Set<Gabarito> gabaritoList) {
        this.gabaritoList = gabaritoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idResposta != null ? idResposta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Resposta)) {
            return false;
        }
        Resposta other = (Resposta) object;
        if ((this.idResposta == null && other.idResposta != null) || (this.idResposta != null && !this.idResposta.equals(other.idResposta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "generator.Resposta[ idResposta=" + idResposta + " ]";
    }
    
}
