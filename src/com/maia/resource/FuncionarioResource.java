package com.maia.resource;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.maia.model.Departamento;
import com.maia.model.Funcionario;
import com.maia.model.enums.Status;

@Path("/funcionarios")
public class FuncionarioResource {

	private int id = 1;
	private Map<Integer, Funcionario> funcionarios = new ConcurrentHashMap<>();

	public FuncionarioResource() {
		this.adicionarFuncionario();
	}

	private void adicionarFuncionario() {

	}

	/*Buscar Por Ativos*/
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public Departamento getFuncionario(@DefaultValue("ativo") @QueryParam("status") String status) {

		List<Funcionario> lista = new ArrayList<Funcionario>();

		for (Object key : funcionarios.keySet()) {
			Funcionario func = funcionarios.get(key);

			if (func.getStatus().getDescricao().equalsIgnoreCase(status)) {
				lista.add(func);
			}
		}

		Departamento departamento = new Departamento(lista);
		return departamento;
	}

	/*Buscar Por inativos*/
	@GET
	@Path("/inativos")
	@Produces(MediaType.APPLICATION_XML)
	public Departamento getFuncionariosInativos() {

		List<Funcionario> lista = new ArrayList<>();

		for (Object key : funcionarios.keySet()) {
			Funcionario func = funcionarios.get(key);

			if (func.getStatus() == Status.I) {
				lista.add(func);
			}
		}
		Departamento departamento = new Departamento(lista);
		return departamento;

	}
	
	/*Buscar Por Salario*/
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public Departamento getFuncionarioPorSalario() {
		
		
		
		return null;		
	}
	
	/*Novo Funcionario*/
	@POST
	public void novoFuncionario() {
		
	}

}
