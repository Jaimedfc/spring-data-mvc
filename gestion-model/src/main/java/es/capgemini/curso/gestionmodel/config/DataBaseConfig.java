package es.capgemini.curso.gestionmodel.config;

import javax.persistence.EntityManagerFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = { "es.capgemini.curso.gestionmodel.model" })
public class DataBaseConfig {

	@Bean
	public LocalEntityManagerFactoryBean entityManagerFactory() {
		LocalEntityManagerFactoryBean factory = new LocalEntityManagerFactoryBean();

		/*
		 * Cargar la unidad de persistencia del fichero persistence.xml
		 * 
		 * jpa-mysql => MySQL
		 * 
		 * jpa-h2 => H2
		 */
		factory.setPersistenceUnitName("jpa-mysql" );

		return factory;
	}

	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
		JpaTransactionManager txManager = new JpaTransactionManager();

		txManager.setEntityManagerFactory(entityManagerFactory);

		return txManager;
	}
}
