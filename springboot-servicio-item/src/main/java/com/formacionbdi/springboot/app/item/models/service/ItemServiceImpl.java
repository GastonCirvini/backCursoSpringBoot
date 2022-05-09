package com.formacionbdi.springboot.app.item.models.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.formacionbdi.springboot.app.item.models.Item;
import com.formacionbdi.springboot.app.item.models.Producto;

//En el momento de la creación de la clase se añade ItemService de forma manual y ya implementa todos sus métodos

@Service
public class ItemServiceImpl implements ItemService {

	
	@Autowired
	private RestTemplate clienteRest;
	//Bean registrado del AppConfig a través del Autowired.
	
	@Override
	public List<Item> findAll() {
		//El getforObject toma la lista del otro microservicio, después de la coma está el tipo de respuesta que vamos a obtener. 
		//En este caso la lista es un array.
		//Esto retorna un arreglo de producto, pero queremos convertirlo en tipo lista. En ese caso...
		//Se coloca la clase Arrays.asList para que lo transforme como lista.
		List <Producto> productos = Arrays.asList(clienteRest.getForObject("http://localhost:8001/listar", Producto[].class));
		
		
		//se transforma productos en una lista de item utilizando stream (JDK8), se utiliza el map para cambiar
		//a objeto item, se pasa por argumento una función flecha (lambda) se le colca p como variable y
		//le pasamos p y el 1. El collect y el collectors.tolist para finalizar.
		return productos.stream().map(p -> new Item (p, 1)).collect(Collectors.toList());
	}

	@Override
	public Item findById(Long id, Integer cantidad) {
		Map<String, String> pathVariables = new HashMap<String, String>();
		pathVariables.put("id", id.toString());
	Producto producto = clienteRest.getForObject("http://localhost:8001/ver/{id}", Producto.class, pathVariables);
		return new Item(producto, cantidad);
	}

}
