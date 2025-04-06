package modelo;

import java.util.UUID;

public class Producto {
    String id;
    String nombre, descripcion;
    String categoria;
    double precio;

    public Producto() {
        this.id = UUID.randomUUID().toString();
    }

    public Producto(String nombre, String descripcion, String categoria, double precio) {
        this.id = UUID.randomUUID().toString();
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.precio = precio;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", categoria=" + categoria +
                ", precio=" + precio +
                '}';
    }
}
    
    
