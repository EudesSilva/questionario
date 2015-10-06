 package br.com.questionario.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.List;
import java.util.Set;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author EudesSilva
 */
@Entity
@Table(name = "pergunta")  
//@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="idPergunta")
public class Pergunta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPergunta")
    private Long idPergunta;
    @Column(name = "descricaoPergunta")
    private String descricaoPergunta;
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
    @Column(name = "tipoPergunta")
   // @Type(type = "boolean")
    private boolean tipoPergunta; 
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
    private String respostaPergunta;  
     //@JsonBackReference
    //@JsonIgnore
    @JoinColumn(name = "idQuestionario",foreignKey = @ForeignKey(name="Pergunta_Questionario") )//, referencedColumnName = "idQuestionario")
    @ManyToOne//(optional = false, fetch = FetchType.EAGER)
    private Questionario questionario;
    
   // @JsonManagedReference 
    @JsonIgnore 
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "pergunta")  // COMENTAR
    private Set<Gabarito> gabaritoList;

    public Pergunta() {
    }

    public Pergunta(Long idPergunta) {
        this.idPergunta = idPergunta;
    }

    public Pergunta(Long idPergunta, boolean tipoPergunta) {
        this.idPergunta = idPergunta;
        this.tipoPergunta = tipoPergunta;
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

    public boolean isTipoPergunta() {
        return tipoPergunta;
    }
  
    public String getRespostaPergunta() {
        return respostaPergunta;
    }

    public void setRespostaPergunta(String respostaPergunta) {
        this.respostaPergunta = respostaPergunta;
    }

    public Questionario getQuestionario() {
        return questionario;
    }

    public void setQuestionario(Questionario questionario) {
        this.questionario = questionario;
    }
 
    public Long getIdPergunta() {
        return idPergunta;
    }

    public void setIdPergunta(Long idPergunta) {
        this.idPergunta = idPergunta;
    }

    public String getDescricaoPergunta() {
        return descricaoPergunta;
    }

    public void setDescricaoPergunta(String descricaoPergunta) {
        this.descricaoPergunta = descricaoPergunta;
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

    public boolean getTipoPergunta() {
        return tipoPergunta;
    }

    public void setTipoPergunta(boolean tipoPergunta) {
        this.tipoPergunta = tipoPergunta;
    }

    public Questionario getIdQuestionario() {
        return questionario;
    }

    public void setIdQuestionario(Questionario idQuestionario) {
        this.questionario = idQuestionario;
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
        hash += (idPergunta != null ? idPergunta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pergunta)) {
            return false;
        }
        Pergunta other = (Pergunta) object;
        if ((this.idPergunta == null && other.idPergunta != null) || (this.idPergunta != null && !this.idPergunta.equals(other.idPergunta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "generator.Pergunta[ idPergunta=" + idPergunta + " ]";
    }
    
}
