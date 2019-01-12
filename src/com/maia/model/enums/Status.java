package com.maia.model.enums;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

@XmlEnum
public enum Status {

	@XmlEnumValue("Ativo")
	A('A', "Ativo"),

	@XmlEnumValue("Inativo")
	I('I', "Inativo");

	private char id;

	private String descricao;

	private Status(char id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	public char getId() {
		return id;
	}

	public void setId(char id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
