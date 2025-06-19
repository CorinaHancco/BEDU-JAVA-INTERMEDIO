package Sesion_06.Sesion_06.Prueba;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import Sesion_06.Sesion_06.entity.Producto;
import Sesion_06.Sesion_06.repository.ProductoRepository;

@Component
public class ProductoRunner {

    @Bean
    public CommandLineRunner run(ProductoRepository repo) {
        return args -> {
            // Guardar productos
            repo.save(new Producto("Laptop Lenovo", "Laptop para trabajo", 12500.00));
            repo.save(new Producto("Mouse Logitech", "Mouse ergonómico", 350.00));
            repo.save(new Producto("Teclado Mecánico", "Teclado para gamers", 950.00));
            repo.save(new Producto("Monitor", "Monitor 24 pulgadas", 3200.00));

            // Consultas
            System.out.println("\n📦 Productos con precio mayor a 500:");
            repo.findByPrecioGreaterThan(500).forEach(System.out::println);

            System.out.println("\n🔍 Productos que contienen 'lap':");
            repo.findByNombreContainingIgnoreCase("lap").forEach(System.out::println);

            System.out.println("\n🎯 Productos con precio entre 400 y 1000:");
            repo.findByPrecioBetween(400, 1000).forEach(System.out::println);

            System.out.println("\n📘 Productos cuyo nombre empieza con 'm':");
            repo.findByNombreStartingWithIgnoreCase("m").forEach(System.out::println);
        };
    }
}