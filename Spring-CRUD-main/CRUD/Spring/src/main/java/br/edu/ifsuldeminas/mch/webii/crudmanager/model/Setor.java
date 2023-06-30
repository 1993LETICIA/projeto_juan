package br.edu.ifsuldeminas.mch.webii.crudmanager.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="setores")
public class Setor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@NotBlank(message = "Nome não pode ser vazio" )
	private String nome;
	@NotBlank(message = "Responsável pelo setor não pode ser vazio" )
	private String responsavelSet;
	@NotBlank(message = "Horario de funcionamento não pode ser vazio" )
	private String horario;

	public Setor() {};
	
	public Setor(Integer id)
	{
		this.id = id;
		setNome("");
		setResponsavelSet("");
		setHorario("");
	
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getResponsavelSet() {
		return responsavelSet;
	}

	public void setResponsavelSet(String responsavelSet) {
		this.responsavelSet = responsavelSet;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

}
