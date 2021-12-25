package com.eacuamba.faces.bean.learning.componentes_interfaces.tabela_de_dados;

import com.eacuamba.faces.bean.learning.componentes_interfaces.Pais;
import com.eacuamba.faces.bean.learning.componentes_interfaces.PaisDao;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.List;

@Named
@ApplicationScoped
public class TabelaDeDadosBean implements Serializable {
    private List<Pais> paises;
    private Pais novoPais;

    @Inject
    private PaisDao paisDao;

    public TabelaDeDadosBean() {
        this.novoPais = new Pais();
    }

    public List<Pais> getPaises() {
        this.paises = this.paisDao.findAll();
        return paises;
    }

    public void setPaises(List<Pais> paises) {
        this.paises = paises;
    }

    public Pais getNovoPais() {
        return novoPais;
    }

    public void setNovoPais(Pais novoPais) {
        this.novoPais = novoPais;
    }

    public void adicionar(){
        this.paisDao.save(novoPais);
        this.novoPais = new Pais();
    }
}
