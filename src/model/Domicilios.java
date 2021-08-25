package model;

public class Domicilios {

	private String id;
	private String pedido;
	private double precio;
	private String direccion;

	public Domicilios() {

	}

	public Domicilios(String id, String pedido, double precio, String direccion) {

		this.id = id;
		this.pedido = pedido;
		this.precio = precio;
		this.direccion = direccion;
	}

	
	
	
	// Getters and setters

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPedido() {
		return pedido;
	}

	public void setPedido(String pedido) {
		this.pedido = pedido;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

}
