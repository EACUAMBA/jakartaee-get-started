package com.eacuamba.project.jsf.beans;


import com.eacuamba.project.domain.exceptions.NegocioException;
import com.eacuamba.project.domain.model.Lancamento;
import com.eacuamba.project.domain.model.Pessoa;
import com.eacuamba.project.domain.model.enumeration.TipoLancamento;
import com.eacuamba.project.domain.services.LancamentoService;
import com.eacuamba.project.domain.services.PessoaService;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.event.ActionEvent;
import jakarta.faces.event.AjaxBehaviorEvent;
import jakarta.faces.event.ValueChangeEvent;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.LocalTime;
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

    //Executado quando uma acção é executada, acçao dos buttons.
    public void mostraLogSalvamento(ActionEvent actionEvent){
        System.out.println("Registando... " + actionEvent.getSource());
        System.out.println("Registando... " + actionEvent.getComponent());
        System.out.println("Registando2... " + actionEvent);

    }

    //Só é accionado quando o valor doque estamos ouvindo muda, caso não mude não executa.
    public void descricaoModificada(ValueChangeEvent valueChangeEvent){
        System.out.println("Mudanca OLD: " + valueChangeEvent.getOldValue());
        System.out.println("Mudanca NEW: " + valueChangeEvent.getNewValue());
        //Na primeira vezz que executamos estamos forçando uma renderizacaoe ele não processa o salvamento se os dados do formulario não foram alterados ele não vai passar mais por aqui, ja que os dados são iguais.
        FacesContext.getCurrentInstance().renderResponse();
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
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,e.getMessage(),"Lançamento feito sem sucesso!"));
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

    public void dataVencimentoAlterada(AjaxBehaviorEvent event){
        if(this.lancamento.getDataPagamento() == null){
            this.lancamento.setDataPagamento(LocalDateTime.of(this.lancamento.getDataVencimento(), LocalTime.MIN));
        }
    }

}
