package br.com.alura.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.alura.loja.dao.CategoriaDao;
import br.com.alura.loja.dao.ProdutoDao;

@Configuration
public class AppConfig {

	@Bean
	public CategoriaDao categoriaDao() {
		return new CategoriaDao();
	}
	
	@Bean 
	public ProdutoDao produtoDao() {
		return new ProdutoDao();
	}
	
}
