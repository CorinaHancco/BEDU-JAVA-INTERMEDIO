package Reto1;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class MovilidadApp {

    // Simula el cálculo de la ruta con latencia de 2-3 segundos
    public CompletableFuture<String> calcularRuta() {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("🚦 Calculando ruta...");
            try {
                TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(2, 4));
                // Simulación de posible error
                if (Math.random() < 0.1) throw new RuntimeException("Error al calcular la ruta");
            } catch (InterruptedException e) {
                throw new RuntimeException("Interrumpido", e);
            }
            return "Ruta: Centro -> Norte";
        });
    }

    // Simula la estimación de tarifa con latencia de 1-2 segundos
    public CompletableFuture<Double> estimarTarifa() {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("💰 Estimando tarifa...");
            try {
                TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(1, 3));
                // Simulación de posible error
                if (Math.random() < 0.1) throw new RuntimeException("Error al estimar la tarifa");
            } catch (InterruptedException e) {
                throw new RuntimeException("Interrumpido", e);
            }
            return 75.50;
        });
    }

    // Combina ambas tareas asincrónicas y maneja errores
    public void procesarSolicitud() {
        CompletableFuture<String> rutaFuture = calcularRuta()
                .exceptionally(e -> {
                    System.out.println("❌ Error en la ruta: " + e.getMessage());
                    return "Ruta no disponible";
                });

        CompletableFuture<Double> tarifaFuture = estimarTarifa()
                .exceptionally(e -> {
                    System.out.println("❌ Error en la tarifa: " + e.getMessage());
                    return -1.0;
                });

        rutaFuture.thenCombine(tarifaFuture, (ruta, tarifa) -> {
            if (tarifa < 0) {
                return "⚠️ No se pudo estimar la tarifa.";
            }
            return "✅ 🚗 " + ruta + " | Tarifa estimada: $" + tarifa;
        }).thenAccept(System.out::println);
    }

    public static void main(String[] args) {
        MovilidadApp app = new MovilidadApp();
        app.procesarSolicitud();

        // Mantenemos el hilo principal vivo por un tiempo para permitir que las tareas se completen
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
