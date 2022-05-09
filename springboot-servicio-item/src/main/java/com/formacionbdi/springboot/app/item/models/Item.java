package com.formacionbdi.springboot.app.item.models;

public class Item {

	private Producto producto;
	private Integer cantidad;

	// Constructor
	public Item() {

	}

	// Constructor de atributos
	public Item(Producto producto, Integer cantidad) {

		this.producto = producto;
		this.cantidad = cantidad;

	}

	// Getters & Setters
	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
	
	//método para calcular el precio total. Precio del producto x la cantidad
	public Double getTotal() {
		return producto.getPrecio()* cantidad.doubleValue();
		
	}

}
