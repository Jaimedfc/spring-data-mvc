package es.capgemini.curso.gestionmodel;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import es.capgemini.curso.gestionmodel.config.DataBaseConfig;
import es.capgemini.curso.gestionmodel.model.CategoriaRepository;
import es.capgemini.curso.gestionmodel.model.ProductoRepository;

public class Test {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DataBaseConfig.class);
		
		ProductoRepository repo = context.getBean(ProductoRepository.class);
		//CategoriaRepository repo = context.getBean(CategoriaRepository.class);
		System.out.println(repo.findAll());
		
		context.close();

	}

}
