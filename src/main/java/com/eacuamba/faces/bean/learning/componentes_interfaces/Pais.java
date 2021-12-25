package com.eacuamba.faces.bean.learning.componentes_interfaces;

import jakarta.persistence.*;

@Entity
@Table(name = "pais")
public class Pais {
    @Id
    @SequenceGenerator(name = "pais_id", sequenceName = "pais_id_seq", initialValue = 1, allocationSize = 50)
    @GeneratedValue(generator = "pais_id", strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "name")
    private String designacao;
    private String iso;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDesignacao() {
        return designacao;
    }

    public void setDesignacao(String designacao) {
        this.designacao = designacao;
    }

    public String getIso() {
        return iso;
    }

    public void setIso(String iso) {
        this.iso = iso;
    }
}
