package br.com.alura.loja.testes;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import br.com.alura.app.AppConfig;
import br.com.alura.loja.dao.CategoriaDao;
import br.com.alura.loja.dao.ProdutoDao;
import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.util.JPAUtil;

public class CadastroProduto {

	public static void main(String[] args) {
		
		cadastrarProduto();
		
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);
		
		Produto p = produtoDao.buscaPorId(1l);
//		List<Produto> todos = produtoDao.buscarTodos();
//		todos.forEach(p2 ->System.out.println(p2.getNome()));
		
		
		List<Produto> todos2 = produtoDao.buscarTodosPorNomeCategoria("CELULARES");
		todos2.forEach(p2 ->System.out.println(p2.getNome()));
		
	}

	private static void cadastrarProduto() {
		Categoria celulares = new Categoria("CELULARES");
		Produto celular = new Produto("Xiaomi8", "Very Nice" , new BigDecimal("700"),celulares );
		
		EntityManager em = JPAUtil.getEntityManager();
		
//		AppConfig appConfig = new AppConfig();
		 ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		 ProdutoDao produtoDao = context.getBean(ProdutoDao.class);
		 CategoriaDao categoriaDao = new CategoriaDao();
		
		
	
//	ProdutoDao ProdutoDao = new ProdutoDao(em);
		CategoriaDao CategoriaDao = new CategoriaDao(em);
		
		
		em.getTransaction().begin();
		CategoriaDao.cadastrarCategoria(celulares);
		produtoDao.cadastrar(celular);
		
		em.getTransaction().commit();
		em.close();
	}
	
}
