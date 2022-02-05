package com.eacuamba.faces.bean;

import com.eacuamba.domain.exceptions.NegocioException;
import com.eacuamba.domain.model.Lancamento;
import com.eacuamba.domain.model.Pessoa;
import com.eacuamba.domain.model.enumeration.TipoLancamento;
import com.eacuamba.domain.services.LancamentoService;
import com.eacuamba.domain.services.PessoaService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class RegistoLancamentoBean implements Serializable {
    @Inject
    private LancamentoService lancamentoService;
    @Inject
    private PessoaService pessoaService;
    private List<Pessoa> pessoaList;
    private Lancamento lancamento = new Lancamento();

    public void prepararCadastro(){
        this.pessoaList = this.pessoaService.buscarTodasPessoas();
    }

    public void salvar(){
        FacesContext facesContext = FacesContext.getCurrentInstance();
        try{
            this.lancamentoService.salvar(this.lancamento);
            facesContext.addMessage(
                    null,
                    new FacesMessage("Lançamento feito com sucesso!"));
            this.lancamento = new Lancamento();
        } catch (NegocioException e) {
            facesContext.addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,e.getMessage(),"Lançamento feito com sucesso!"));
        }
    }

    public Pessoa[] getPessoas(){
        return this.pessoaList.toArray(new Pessoa[]{});
    }
    public TipoLancamento[] getTiposDeLancamento(){
        return TipoLancamento.values();
    }
    public Lancamento getLancamento(){
        return this.lancamento;
    }
    public void setLancamento(Lancamento lancamento){
        this.lancamento = lancamento;
    }


}
