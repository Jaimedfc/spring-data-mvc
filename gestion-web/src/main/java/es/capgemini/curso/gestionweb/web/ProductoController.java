package es.capgemini.curso.gestionweb.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import es.capgemini.curso.gestionmodel.model.CategoriaRepository;
import es.capgemini.curso.gestionmodel.model.ProductoRepository;
import es.capgemini.curso.gestionmodel.model.entities.Categoria;
import es.capgemini.curso.gestionmodel.model.entities.Producto;

@Controller
@RequestMapping("/")
public class ProductoController {

	@Autowired
	private CategoriaRepository catRepo;
	
	@Autowired
	private ProductoRepository prodRepo;

	@GetMapping(path = { "/", "/list" })
	public ModelAndView index(@RequestParam(name = "categoria", required = false) Optional<Integer> idCategoria) {
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("categorias", catRepo.findAll());
		if(idCategoria.isPresent()){
			Optional<Categoria> categoria = catRepo.findById(idCategoria.get());
			if (categoria.isPresent()) mv.addObject("productos", prodRepo.findByCategoria(categoria.get()));
		}
		return mv;
	}


	
	@GetMapping("/producto/{id}")
	public ModelAndView saveAddCustomer(@PathVariable("id") int idProducto) {
		Optional<Producto> productoOpt = prodRepo.findById(idProducto);
		if(productoOpt.isPresent()) {
			return new ModelAndView("producto", "producto", productoOpt.get());
		}
		return new ModelAndView("index", "categorias", catRepo.findAll());
	}
	
}
