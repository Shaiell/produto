package br.up.produto.web;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.up.produto.entidades.Marca;
import br.up.produto.servicos.MarcaServico;

/**
 * Class created to interpret data.
 * @author jclri
 *
 */
@Named
@RequestScoped
public class MarcaBean {
	
	@EJB
	private MarcaServico marcaServico;
	
	private Marca marca;
	
	private List<Marca> marcas;
	
	public MarcaBean() {
		this.marca = new Marca();
	}
	
	public void cadastrarMarca() {
		try {
		this.marcaServico.cadastrarMarca(marca);
		JSFUtils.enviarMensagemDeInformacao("Marca Cadastrada");
		this.marca = new Marca();
		}catch (Exception e) {
			JSFUtils.enviarMensagemDeAtencao(e.getMessage());
		}
	}
	
	public void excluirMarca(Marca marca) {
		try {
		this.marcaServico.excluirMarca(marca);
		JSFUtils.enviarMensagemDeInformacao("Marca Excluida");
		}catch (Exception e) {
			JSFUtils.enviarMensagemDeAtencao(e.getMessage());
		}
	}
	
	public List<Marca> listarMarcas(){
		return this.marcaServico.listarMarca();
	}

	public MarcaServico getMarcaServico() {
		return marcaServico;
		
	}

	public void setMarcaServico(MarcaServico marcaServico) {
		this.marcaServico = marcaServico;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public List<Marca> getMarcas() {
		if(this.marcas ==null) {
			this.marcas = this.marcaServico.listarMarca();
		}
		return marcas;
	}

	public void setMarcas(List<Marca> marcas) {
		this.marcas = marcas;
	}



}
