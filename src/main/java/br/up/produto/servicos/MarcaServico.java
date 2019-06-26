package br.up.produto.servicos;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.up.produto.entidades.Marca;
import br.up.produto.entidades.Produto;

/**
 * Class created to manage a brand.
 * @author jclri
 *
 */
@Stateless
public class MarcaServico {
	
	@PersistenceContext
	private EntityManager em;
	
	/**
	 * method created to insert a tag into the database.
	 * @param marca
	 * @throws Exception 
	 */
	public void cadastrarMarca(Marca marca) throws Exception {
		if(listarMarcaPorNome(marca).isEmpty()) {
		this.em.persist(marca);
		}else {
			throw new Exception("Marca já Cadastrada.");
		}
	}
	
	/**
	 * method created to remove a tag into the database.
	 * @param marca
	 * @throws Exception 
	 */
	public void excluirMarca(Marca marca) throws Exception {
		if(listarProdutoPorMarca(marca).isEmpty()) {
		this.em.remove(this.em.merge(marca));
		}else {
			throw new Exception("Não é possivel excluir pois existe um produto cadastrado com esta marca.");
		}
	}
	
	/**
	 * method crated to list database data.
	 * @return
	 */
	public List<Marca> listarMarca(){
		Query query = this.em.createQuery("SELECT m FROM Marca m", Marca.class);
		return query.getResultList();
	}

	public List<Marca> listarMarcaPorNome(Marca marca){
		Query query = this.em.createQuery("SELECT m FROM Marca m WHERE m.nome=:p1", Marca.class);
		query.setParameter("p1", marca.getNome());
		return query.getResultList();
	}
	
	public List<Produto> listarProdutoPorMarca(Marca marca){
		Query query = this.em.createQuery("SELECT p FROM Produto p WHERE p.marca=:p1", Produto.class);
		query.setParameter("p1", marca);
		return query.getResultList();
	}
	
}
