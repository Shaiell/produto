package br.up.produto.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;

/**
 * Class created to represent a brand.
 * @author jclri
 *
 */
@Entity
public class Marca {
	
	@Id
	@SequenceGenerator(name = "CONTADOR_MARCA", sequenceName = "NUM_SEQ_MARCA", allocationSize = 0)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CONTADOR_MARCA")
	private Integer id;

	@NotBlank
	private String nome;
	
	@NotBlank
	private String descricao;
	
	public Marca() {
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
