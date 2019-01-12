package com.maia.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(value = XmlAccessType.FIELD)
public class Endereco implements Serializable {
	private static final long serialVersionUID = 1L;

	@XmlAttribute(name = "id")
	private int id;
	
	private String rua;
	
	private String bairro;
	
	private String cidade;

	public Endereco() {}

	public Endereco(int id, String rua, String bairro, String cidade) {
		this.id = id;
		this.rua = rua;
		this.bairro = bairro;
		this.cidade = cidade;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

}
