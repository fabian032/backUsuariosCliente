package co.edu.unbosque.backTienda1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.backTienda1.models.Usuarios;
import co.edu.unbosque.backTienda1.repositories.UsuariosDAO;

@RestController
@CrossOrigin(origins ="*",methods = { RequestMethod.POST, RequestMethod.GET, RequestMethod.PUT,
		RequestMethod.DELETE})
@RequestMapping("/api/usuarios")
public class UsuariosAPI {
	
	@Autowired
	private UsuariosDAO usuariosdao;
	
	@PostMapping("/guardar")
	public  Usuarios guardar(@Validated @RequestBody Usuarios usuarios) {
		return usuariosdao.insert(usuarios);
	}
	
	@GetMapping("/listar")
	public List<Usuarios> listar(){
		return usuariosdao.findAll();
	}
	
	@PutMapping("/actualizar")
	public void actualizar(@RequestBody Usuarios usuarios) {
		usuariosdao.save(usuarios);
		
	}
	
	@DeleteMapping("/eliminar/{id}")
	public void eliminar(@PathVariable String id) {
		usuariosdao.deleteById(id);
	}
}
