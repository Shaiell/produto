package br.up.produto.web;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.up.produto.entidades.Produto;
import br.up.produto.servicos.ProdutoServico;

/**
 * Class created to interpret data.
 * @author jclri
 *
 */
@Named
@RequestScoped
public class ProdutoBean {
	
	@EJB
	private ProdutoServico produtoServico;

	private Produto produto;
	
	public ProdutoBean() {
		this.produto = new Produto();
	}
	
	public void cadastrarProduto() {
		
		try {
		this.produtoServico.cadastrarProduto(produto);
		JSFUtils.enviarMensagemDeInformacao("Produto Cadastrado");
		this.produto = new Produto();
		}catch (Exception e) {
			JSFUtils.enviarMensagemDeAtencao(e.getMessage());
		}
	}
	
	public void excluirProduto(Produto produto) {
		this.produtoServico.excluirProduto(produto);
		JSFUtils.enviarMensagemDeInformacao("Produto Excluido");
	}
	
	public List<Produto> listarProduto(){
		return this.produtoServico.listarProduto();
	}
	
	public ProdutoServico getProdutoServico() {
		return produtoServico;
	}

	public void setProdutoServico(ProdutoServico produtoServico) {
		this.produtoServico = produtoServico;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

}
