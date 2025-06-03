package Reto2;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        // Datos de ejemplo
        Sucursal centro = new Sucursal("Centro", Arrays.asList(
                new Encuesta("Juan", "El tiempo de espera fue largo", 2),
                new Encuesta("Ana", null, 3),
                new Encuesta("Luis", "Todo bien", 5)
        ));

        Sucursal norte = new Sucursal("Norte", Arrays.asList(
                new Encuesta("Carlos", "La atención fue buena, pero la limpieza puede mejorar", 3),
                new Encuesta("Elena", null, 4),
                new Encuesta("Mario", "Muy lento el servicio", 2)
        ));

        List<Sucursal> sucursales = Arrays.asList(centro, norte);

        // Proceso con Stream API
        sucursales.stream()
                .flatMap(sucursal ->
                        sucursal.getEncuestas().stream()
                                .filter(e -> e.getCalificacion() <= 3)
                                .map(Encuesta::getComentario)
                                .filter(Optional::isPresent)
                                .map(Optional::get)
                                .map(comentario -> "Sucursal " + sucursal.getNombre() +
                                        ": Seguimiento a paciente con comentario: \"" + comentario + "\"")
                )
                .forEach(System.out::println);
    }
}