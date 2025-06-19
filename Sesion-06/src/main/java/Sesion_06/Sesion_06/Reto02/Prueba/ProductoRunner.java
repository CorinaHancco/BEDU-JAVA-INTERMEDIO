package Sesion_06.Sesion_06.Reto02.Prueba;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import Sesion_06.Sesion_06.Reto02.entity.Marca;
import Sesion_06.Sesion_06.Reto02.entity.Producto;
import Sesion_06.Sesion_06.Reto02.repository.MarcaRepository;
import Sesion_06.Sesion_06.Reto02.repository.ProductoRepository;

@Component
public class ProductoRunner {

    @Bean
    public CommandLineRunner run(MarcaRepository marcaRepo, ProductoRepository productoRepo) {
        return args -> {
            // Crear marcas
            Marca apple = marcaRepo.save(new Marca("Apple"));
            Marca samsung = marcaRepo.save(new Marca("Samsung"));

            // Asociar productos
            productoRepo.save(new Producto("iPhone 15", "Smartphone de alta gama", 20000.00, apple));
            productoRepo.save(new Producto("iPad Pro", "Tablet profesional", 18000.00, apple));
            productoRepo.save(new Producto("Galaxy S23", "Smartphone Android", 17000.00, samsung));
            productoRepo.save(new Producto("Smart TV", "Televisor 4K", 15000.00, samsung));

            // Mostrar productos por marca
            System.out.println("\n📚 Productos por marca:");
            marcaRepo.findAll().forEach(marca -> {
                System.out.println("🏷️ " + marca.getNombre() + ":");
                productoRepo.findAll().stream()
                        .filter(p -> p.getMarca().getId().equals(marca.getId()))
                        .forEach(p -> System.out.println("   - " + p.getNombre()));
            });
        };
    }
}
