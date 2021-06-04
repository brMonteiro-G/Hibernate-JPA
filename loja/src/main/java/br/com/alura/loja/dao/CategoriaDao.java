package br.com.alura.loja.dao;

import javax.persistence.EntityManager;

import br.com.alura.loja.modelo.Categoria;

public class CategoriaDao {

	private EntityManager em ;
	
	
	public CategoriaDao() {
		
	}
	
	public CategoriaDao(EntityManager em ){
		this.em = em;
	}
	
	
	public void cadastrarCategoria(Categoria categoria) {
		em.persist(categoria);
	}
	
	
	public void atualizarCategoria(Categoria categoria) {
		this.em.merge(categoria);
	}
}
