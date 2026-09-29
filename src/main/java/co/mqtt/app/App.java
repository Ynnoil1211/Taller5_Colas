package co.mqtt.app;

import co.mqtt.queue.ServidorMQTT;

public class App {

    public static void main(String[] args) {
        ServidorMQTT server = new ServidorMQTT();

        System.out.println("Operación 1: Publicar S01 - Temperatura");
        server.publicar("S01", "28.5 °C");

        System.out.println("\nOperación 2: Publicar S02 - Humedad");
        server.publicar("S02", "76 %");

        System.out.println("\nOperación 3: Publicar S03 - Nivel");
        server.publicar("S03", "45 cm");

        System.out.println("\nOperación 4: Procesar (retirar el primer mensaje)");
        server.procesar();

        System.out.println("\nOperación 5: Publicar S01 - Temperatura");
        server.publicar("S01", "29.1 °C");

        System.out.println("\nOperación 6: Procesar (retirar el siguiente mensaje)");
        server.procesar();

        System.out.println("\nOperación 7: Procesar (retirar el siguiente mensaje)");
        server.procesar();

        System.out.println("\nOperación 8: Procesar (retirar el siguiente mensaje)");
        server.procesar();

        System.out.println("\nOperación 9: Procesar (cola vacía)");
        server.procesar();
    }
}