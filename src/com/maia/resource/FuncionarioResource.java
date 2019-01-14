package com.maia.resource;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.maia.model.Departamento;
import com.maia.model.Funcionario;
import com.maia.model.enums.Status;

/**
 * Projeto de Estudos em RESTFul  com JavaEE e RESTEasy
 * 
 *  */
@Path("/funcionarios")
public class FuncionarioResource {

	private int id = 1;
	private Map<Integer, Funcionario> funcionarios = new ConcurrentHashMap<>();

	public FuncionarioResource() {
		this.adicionarFuncionario();
	}

	private void adicionarFuncionario() {

	}

	/* Buscar Por Ativos */
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

	/* Buscar Por inativos */
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

	// bucsar por nome
	@GET
	@Path("/funcionario")
	@Produces(MediaType.APPLICATION_XML)
	public Funcionario getFuncNome(@QueryParam("nome") String nome, @QueryParam("sobrenome") String sobrenome) {

		for (Object key : funcionarios.keySet()) {
			Funcionario func = funcionarios.get(key);

			if (func.getNome().equalsIgnoreCase(nome) && func.getSobrenome().equalsIgnoreCase(sobrenome)) {

				return func;
			}
		}
		return null;
	}

	/* Buscar Por Salario - com valores de minimo e maximo como paramentros */
	@GET
	@Path("/salario")
	@Produces(MediaType.APPLICATION_XML)
	public Departamento getFuncionarioPorSalario(@DefaultValue("0") @MatrixParam("minimo") String minimo,
			@DefaultValue("5000") @MatrixParam("maximo") String maximo) {

		Double salMinimo = Double.parseDouble(minimo);
		Double salMaximo = Double.parseDouble(maximo);

		List<Funcionario> lista = new ArrayList<>();

		for (Object key : funcionarios.keySet()) {
			Funcionario func = funcionarios.get(key);

			if (func.getSalario() >= salMinimo && func.getSalario() <= salMaximo) {
				lista.add(func);
			}
		}

		Departamento dep = new Departamento(lista);
		return dep;
	}

	/* Novo Funcionario */
	@POST
	public void novoFuncionario(
			@QueryParam("nome") String nome, 
			@QueryParam("sobrenome") String sobrenome,
			@QueryParam("salario") String salario, 
			@QueryParam("status") String status) {

		Double sal = Double.parseDouble(salario); // convert String em Double

		Funcionario func = new Funcionario();
		func.setId(id++);
		func.setNome(nome);
		func.setSobrenome(sobrenome);
		func.setSalario(sal);
		if (status.equals("A")) {
			func.setStatus(Status.A);
		} else {
			func.setStatus(Status.I);
		}
		funcionarios.put(func.getId(), func);
	}
	
	/* Adicioando Funcioanrio para fazer uma simulando de consultas ao banco de dados */
	private void addFuncionario() {
		Funcionario f1 = new Funcionario();
		f1.setId(id++);
		f1.setNome("Dowglas");
		f1.setSobrenome("Maia");
		f1.setSalario(2500.00);
		f1.setStatus(Status.A);
		
		///		
		
		Funcionario f2 = new Funcionario();
		f2.setId(id++);
		f2.setNome("Kayron");
		f2.setSobrenome("Colares");
		f2.setSalario(12500.00);
		f2.setStatus(Status.A);
		
		///		
		
		Funcionario f3 = new Funcionario();
		f3.setId(id++);
		f3.setNome("Marcos");
		f3.setSobrenome("Luz");
		f3.setSalario(1500.00);
		f3.setStatus(Status.I);
		
		///
		
		Funcionario f4 = new Funcionario();
		f4.setId(id++);
		f4.setNome("Elio Carlos");
		f4.setSobrenome("Lima");
		f4.setSalario(1000.00);
		f4.setStatus(Status.A);
		
		//
		
		Funcionario f5 = new Funcionario();
		f5.setId(id++);
		f5.setNome("Marcos Andrade");
		f5.setSobrenome("Cunha");
		f5.setSalario(15000.00);
		f5.setStatus(Status.I);
		
		funcionarios.put(f1.getId(), f1);
		funcionarios.put(f2.getId(), f2);
		funcionarios.put(f2.getId(), f2);
		funcionarios.put(f4.getId(), f4);
		funcionarios.put(f5.getId(), f5);
		
		
		
	}
	

}
