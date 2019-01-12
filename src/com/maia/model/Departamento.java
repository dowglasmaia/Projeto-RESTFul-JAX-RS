package com.maia.model;

import java.io.Serializable;
import java.util.Collection;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(value = XmlAccessType.FIELD)
public class Departamento implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@XmlElement(name = "funcionario")
	private Collection<Funcionario>funcionarios;
	
	public Departamento() {}

	public Departamento(Collection<Funcionario> funcionarios) {
		super();
		this.funcionarios = funcionarios;
	}

	public Collection<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(Collection<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}
	
	

}
