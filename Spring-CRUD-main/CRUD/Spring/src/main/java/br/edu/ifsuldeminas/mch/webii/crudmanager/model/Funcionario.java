package br.edu.ifsuldeminas.mch.webii.crudmanager.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;



@Entity
@Table(name="funcionarios")
public class Funcionario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@NotBlank(message = "Nome não pode ser vazio" )
    private String nome;
   @NotBlank(message = "Função não pode ser vazio" )
   private String funcao;
   @NotBlank(message = "E-mail não pode ser vazio" )
   private String email;
    
    @ManyToOne
    @JoinColumn(name="setor_id", nullable = false)
    private Setor setor;
	
	public Funcionario() {};
	
	public Funcionario(Integer id)
	{
		this.id = id;
		setNome("");
		setFuncao("");
		setEmail("");

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

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Setor getSetor() {
		return setor;
	}

	public void setSetor(Setor setor) {
		this.setor = setor;
	}

}
