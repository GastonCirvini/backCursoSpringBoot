package com.formacionbdi.springboot.app.productos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.formacionbdi.springboot.app.productos.models.entity.Producto;
import com.formacionbdi.springboot.app.productos.models.service.IProductoService;

@RestController  //esta anotación convierte en JSON los métodos Handler
public class ProductoController {

	@Autowired
	private IProductoService productoService;
	
	@GetMapping("/listar")
	public List <Producto> listar(){
		return productoService.findAll();
	}
	
	@GetMapping ("/ver/{id}")
	public Producto detalle(@PathVariable Long id) {
		
		//lo dormimos con thread.sleep 2segundos y se lo anida con trycatch
		/*try {
			Thread.sleep(2000L); //L por Long
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		return productoService.findById(id);
		
		
	}
	
	
	
}
