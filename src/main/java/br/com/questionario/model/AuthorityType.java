package br.com.questionario.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "authorityType")
public class AuthorityType implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "authorityType_id")
    private Integer id;
    @Column(name = "authorityType_name", nullable = false)
    private String authorityTypeName;

    public AuthorityType() {
    }

    public AuthorityType(String authorityTypeName) {
        this.authorityTypeName = authorityTypeName;
    }

    public AuthorityType(Integer id, String authorityTypeName) {
        this.id = id;
        this.authorityTypeName = authorityTypeName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getauthorityTypeName() {
        return authorityTypeName;
    }

    public void setAuthorityTypeName(String roleName) {
        this.authorityTypeName = roleName;
    }

}
