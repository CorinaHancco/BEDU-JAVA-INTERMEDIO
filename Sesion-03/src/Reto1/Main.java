package Reto1;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        List<Pedido> pedidos = Arrays.asList(
                new Pedido("Carlos", "domicilio", "555-1234"),
                new Pedido("Ana", "local", "555-9999"),
                new Pedido("Luis", "domicilio", null),
                new Pedido("Maria", "domicilio", "555-5678")
        );

        pedidos.stream()
                .filter(pedido -> "domicilio".equalsIgnoreCase(pedido.getTipoEntrega()))
                .map(Pedido::getTelefono)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .map(telefono -> "📞 Confirmación enviada al número: " + telefono)
                .forEach(System.out::println);
    }
}
