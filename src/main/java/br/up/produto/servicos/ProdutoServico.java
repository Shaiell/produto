package br.up.produto.servicos;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.up.produto.entidades.Marca;
import br.up.produto.entidades.Produto;

/**
 * Class creatd to manage a produtc.
 * @author jclri
 *
 */
@Stateless
public class ProdutoServico {
	
	@PersistenceContext
	private EntityManager em;
	
	/**
	 * method created to insert a product into the database.
	 * @param produto
	 * @throws Exception 
	 */
	public void cadastrarProduto (Produto produto) throws Exception {
		if(listarProdutoPorNome(produto).isEmpty()) {
		this.em.persist(produto);
		}else {
			throw new Exception("Produto já Cadastrado");
		}
	}
	
	/**
	 * method created to remove a product into the database.
	 * @param produto
	 */
	public void excluirProduto(Produto produto) {
		this.em.remove(this.em.merge(produto));
	}
	
	/**
	 * method crated to list database data.
	 * @return
	 */
	public List<Produto> listarProduto(){
		Query query = this.em.createQuery("SELECT p FROM Produto p", Produto.class);
		return query.getResultList();
	}
	
	public List<Produto> listarProdutoPorNome(Produto produto){
		Query query = this.em.createQuery("SELECT p FROM Produto p WHERE p.nome=:p1", Produto.class);
		query.setParameter("p1", produto.getNome());
		return query.getResultList();
	}
	
	

}
