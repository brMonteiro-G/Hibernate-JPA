package br.com.alura.loja.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.loja.modelo.Produto;

public class ProdutoDao {

	private EntityManager em;
	//para usar como injeção de dependência
	public ProdutoDao(EntityManager em) {
		this.em = em;
	}
	
	public ProdutoDao() {
		
	}

	public void cadastrar(Produto produto) {
		this.em.persist(produto);
		
	}
	
	public Produto buscaPorId(Long id) {
		return em.find(Produto.class, id);
	}
	
	public List<Produto> buscarTodos(){
		String jpql = " SELECT p FROM Produto p";
		return em.createQuery(jpql, Produto.class).getResultList();
	}
	
	public List<Produto> buscarTodosPorNomeCategoria(String nome){
		String jpql = "SELECT p FROM Produto p WHERE p.categoria.nome = :nome";
		return em.createQuery(jpql, Produto.class).setParameter("nome", nome).getResultList();
	}
	
}
