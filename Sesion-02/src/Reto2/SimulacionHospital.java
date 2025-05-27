package Reto2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimulacionHospital {
    public static void main(String[] args) {
        System.out.println("🏥 Iniciando acceso a la Sala de cirugía...\n");

        RecursoMedico salaCirugia = new RecursoMedico("Sala de cirugía");

        String[] profesionales = {
                "Dra. Sánchez", "Dr. Gómez", "Enf. Ramírez", "Dra. López", "Dr. Torres"
        };

        ExecutorService executor = Executors.newFixedThreadPool(4);

        for (String nombre : profesionales) {
            Runnable tarea = () -> salaCirugia.usar(nombre);
            executor.execute(tarea);
        }

        executor.shutdown(); // Finaliza el executor después de enviar todas las tareas
    }
}
