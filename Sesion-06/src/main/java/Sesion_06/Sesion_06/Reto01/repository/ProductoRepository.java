package Sesion_06.Sesion_06.Reto01.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Sesion_06.Sesion_06.Reto01.entity.Producto;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
    List<Producto> findByPrecioGreaterThan(double precio);
    List<Producto> findByNombreContainingIgnoreCase(String nombre);
    List<Producto> findByPrecioBetween(double min, double max);
    List<Producto> findByNombreStartingWithIgnoreCase(String prefijo);
}
