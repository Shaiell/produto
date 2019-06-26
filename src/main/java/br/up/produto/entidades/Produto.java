package br.up.produto.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * Class created to represent a product.
 * @author jclri
 *
 */
@Entity
public class Produto {
	
	@Id
	@SequenceGenerator(name = "CONTADOR_PRODUTO", sequenceName = "NUM_SEQ_PRODUTO", allocationSize = 0)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CONTADOR_PRODUTO")
	private Integer id;
	
	@NotBlank (message = "O nome do produto é obrigatorio")
	private String nome;
	
	@NotNull
	@DecimalMin ( value ="0.01")
	private Double preco;
	
	@NotNull (message = "É obrigatorio a seleção de uma marca. ")
	@ManyToOne
	@JoinColumn(name = "fk_marca")
	private Marca marca;
	
	public Produto() {
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

}
