package curso.hibernate.modelo;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
@Entity
@Table(name="usr_usuario")
public class Usuario {
	
	private Integer id;
	private String nome;
	private Date dataNascimento;
	private Integer idade;
	private EstadoCivil estadoCivil;
	//private Endereco endereco;
	//private Endereco enderecoComercial;
	//private List<Endereco> enderecos = new ArrayList<>();
	private Veiculo veiculo;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
	@Temporal(TemporalType.DATE)
	@Column(name = "data_nascimento")
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	@Transient
	public Integer getIdade() {
		return idade;
	}
	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	@Enumerated(EnumType.STRING)
	@Column(name="estado_civil")
	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}
	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	//define um relacionamento de 1 para 1 com atualização em cascata
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id_veiculo")
	public Veiculo getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	
	//Anotação que cria uma segunda tabela no banco
	/*@ElementCollection(fetch = FetchType.EAGER)
	//Muda o nome da tabela
	@JoinTable(name="usu_endereco", joinColumns = @JoinColumn(name="id_usuario"))
	public List<Endereco> getEnderecos() {
		return enderecos;
	}
	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}*/
	
	
	/*@Embedded
	//sobreescreve o atributo da tabela
	@AttributeOverrides({
		@AttributeOverride(name="logradouro", column=@Column(name="rua"))
	})
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	@Embedded
	//sobreescreve o atributo da tabela (logradouro, cidade e numero)
	@AttributeOverrides({
		@AttributeOverride(name="logradouro", column=@Column(name="logC")),
		@AttributeOverride(name="cidade", column=@Column(name="cidC")),
		@AttributeOverride(name="numero", column=@Column(name="numC"))
	})
	public Endereco getEnderecoComercial() {
		return enderecoComercial;
	}
	public void setEnderecoComercial(Endereco enderecoComercial) {
		this.enderecoComercial = enderecoComercial;
	}*/
	
	

}
