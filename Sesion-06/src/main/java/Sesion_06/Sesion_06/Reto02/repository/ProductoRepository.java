package Sesion_06.Sesion_06.Reto02.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import Sesion_06.Sesion_06.Reto02.entity.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
    List<Producto> findByPrecioGreaterThan(double precio);
    List<Producto> findByNombreContainingIgnoreCase(String nombre);
    List<Producto> findByPrecioBetween(double min, double max);
    List<Producto> findByNombreStartingWithIgnoreCase(String prefijo);
}