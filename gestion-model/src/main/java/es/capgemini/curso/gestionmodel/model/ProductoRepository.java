package es.capgemini.curso.gestionmodel.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.capgemini.curso.gestionmodel.model.entities.Categoria;
import es.capgemini.curso.gestionmodel.model.entities.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer>{

	public List<Producto> findByCategoria(Categoria categoria);
}
