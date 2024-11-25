package modelo;

public class Producto {
    private String nombre;
    private double precio;
    
    
    //getters and setters
    public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	
	
    public void mostrarDetalles() {
        System.out.println("Producto: " + nombre + ", Precio: $" + precio);
    }
}
