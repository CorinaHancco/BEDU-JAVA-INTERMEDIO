package Sesion_06.Sesion_06.Reto01.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre no puede estar en blanco")
    private String nombre;

    @NotBlank(message = "La descripción no puede estar en blanco")
    private String descripcion;

    @Min(value = 1, message = "El precio debe ser al menos 1")
    private double precio;

    // Constructor vacío requerido por JPA
    public Producto() {
    }

    public Producto(String nombre, String descripcion, double precio) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    // Getters y setters...

    @Override
    public String toString() {
        return "Producto[id=" + id + ", nombre='" + nombre + "', precio=" + precio + "]";
    }
}
