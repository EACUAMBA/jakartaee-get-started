package com.eacuamba.endpoint.controller;

import com.eacuamba.project.domain.model.Pessoa;
import com.eacuamba.project.domain.repository.PessoaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/pessoa")
@ApplicationScoped
public class PessoaController {
    @Inject
    private PessoaRepository pessoaRepository;

    @POST
    public Response createPessoa(Pessoa pessoa){
        this.pessoaRepository.save(pessoa);
        return Response.ok(pessoa).build();
    }

    @GET
    public List<Pessoa> getAllPessoa(){

        return this.pessoaRepository.findAll();
    }

    @GET
    @Path("/{id}")
    public Response getPessoa(@PathParam("id") Long id){
        Pessoa pessoa = this.pessoaRepository.findById(id).orElseThrow(()->new NotFoundException(String.format("Pessoa com id (%d) não existe.", id)));
        return Response.status(Response.Status.OK).entity(pessoa).build();
    }
}
