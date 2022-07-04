package com.eacuamba.faces.bean.learning.componentes_interfaces;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

import java.io.Serializable;
import java.util.Comparator;
import java.util.List;

@ApplicationScoped
public class PaisDao implements Serializable {
    @PersistenceContext(unitName = "java_ee_7_com_jsf_primefaces_e_cdi_2_edicao_algaworks")
    private EntityManager entityManager;

    public List<Pais> findAll(){
        TypedQuery<Pais> paisTypedQuery = this.entityManager.createQuery("select pais from Pais  pais", Pais.class);

        List<Pais> typedQueryResultList = paisTypedQuery.getResultList();

        typedQueryResultList.sort(new Comparator<Pais>() {
            @Override
            public int compare(Pais o1, Pais o2) {
                return o1.getDesignacao().compareTo(o2.getDesignacao());
            }
        });

        return typedQueryResultList;
    }

    @Transactional
    public void save (Pais pais) {
        this.entityManager.persist(pais);
    }
}
