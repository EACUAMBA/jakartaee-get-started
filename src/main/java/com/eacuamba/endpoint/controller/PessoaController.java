package com.eacuamba.endpoint.controller;

import com.eacuamba.domain.model.Pessoa;
import com.eacuamba.domain.repository.PessoaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/api/pessoa")
@ApplicationScoped
public class PessoaController {
    @Inject
    private PessoaRepository pessoaRepository;

    @POST
    public Response createPessoa(Pessoa pessoa){
        this.pessoaRepository.create(pessoa);
        return Response.ok(pessoa).build();
    }

    @GET
    public List<Pessoa> getAllPessoa(){
        List<Pessoa> pessoaList = this.pessoaRepository.findAll().orElseThrow(()->new NotFoundException("Sem pessoas no banco de dados"));
        return pessoaList;
    }

    @GET
    @Path("/{id}")
    public Response getPessoa(@PathParam("id") Long id){
        Pessoa pessoa = this.pessoaRepository.findById(id).orElseThrow(()->new NotFoundException(String.format("Pessoa com id (%d) não existe.", id)));
        return Response.status(Response.Status.OK).entity(pessoa).build();
    }
}