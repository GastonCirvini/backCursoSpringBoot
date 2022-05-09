package com.formacionbdi.springboot.app.item;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

	
	//Los Beans es para crear objetos Spring. Lo que retorna se guarda en el contenedor, por el Bean. En este caso entre paréntesis le decimos cómo lo guardamos
	@Bean ("clienteRest")
	public RestTemplate registrarRestTemplate() {
		return new RestTemplate();
		//Es un cliente http. Es una herramienta para acceder a recursos que están en microservicios.
	}
	
}
