package Reto2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<MaterialCurso> materiales = new ArrayList<>();

        // Agregar Videos
        Video v1 = new Video("Introducción a Java", "Mario", 15);
        Video v2 = new Video("POO en Java", "Carlos", 20);

        // Agregar Artículos
        Articulo a1 = new Articulo("Historia de Java", "Ana", 1200);
        Articulo a2 = new Articulo("Tipos de datos", "Luis", 800);

        // Agregar Ejercicios
        Ejercicio e1 = new Ejercicio("Variables y tipos", "Luis");
        Ejercicio e2 = new Ejercicio("Condicionales", "Mario");

        materiales.add(v1);
        materiales.add(v2);
        materiales.add(a1);
        materiales.add(a2);
        materiales.add(e1);
        materiales.add(e2);

        // Mostrar todos los materiales
        PlataformaEducativa.mostrarMateriales(materiales);

        // Contar duración total de videos
        List<Video> videos = List.of(v1, v2);
        PlataformaEducativa.contarDuracionVideos(videos);

        // Marcar ejercicios como revisados
        PlataformaEducativa.marcarEjerciciosRevisados(materiales);

        // Filtrar por autor: Mario
        PlataformaEducativa.filtrarPorAutor(materiales, m -> m.getAutor().equals("Mario"));
    }
}
