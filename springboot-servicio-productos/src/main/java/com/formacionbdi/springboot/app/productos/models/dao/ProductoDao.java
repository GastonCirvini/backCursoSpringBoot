package com.formacionbdi.springboot.app.productos.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.formacionbdi.springboot.app.productos.models.entity.Producto;

//Son protocolos de comportamiento que tienen que implementar algunas clases para cumplir dichos roles o funciones en nuestra función
//Se utilizan las clases services para no tener tantos dao. Es una fachada por si trabajamos con muchos dao.
//El objetivo es hacer granular la aplicación y no que sea monolítica
public interface ProductoDao extends CrudRepository <Producto, Long> {

}
