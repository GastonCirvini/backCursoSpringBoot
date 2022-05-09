package com.formacionbdi.springboot.app.item.clientes;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.formacionbdi.springboot.app.item.models.Producto;

@FeignClient (name = "servicio-productos", url= "localhost:8001") //se conecta al servicio que necesitamos
public interface ProductoClienteRest {
	
	@GetMapping ("/listar") //tiene que ser el mismo endpoint al que queremos conectarnos
	public List <Producto> listar();
	
	@GetMapping ("/ver/{id}")
	public Producto detalle (@PathVariable Long id);
	
	
}
