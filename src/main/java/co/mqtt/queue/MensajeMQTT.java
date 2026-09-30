package co.mqtt.queue;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
/*
Elaborado por:
DANIEL ESTEBAN BORRE CARO - 0222510016
LIONNY LIN LI - 0222510050
MARIA ALEJANDRA RAMOS NAIZIR - 0222510006

--Repo en Github del taller https://github.com/danicpr/Taller5_Colas
 */
public class MensajeMQTT {

    int id;
    String dispositivoId;
    String topic;
    String payload;
    LocalDateTime timestamp;

    MensajeMQTT(
        int id,
        String dispositivoId,
        String topic,
        String payload,
        LocalDateTime timestamp
    ) {
        this.id = id;
        this.dispositivoId = dispositivoId;
        this.topic = topic;
        this.payload = payload;
        this.timestamp = timestamp;
    }

    void mostrarMensaje() {
        System.out.println("ID: " + this.id);
        System.out.println("Dispositivo: " + this.dispositivoId);
        System.out.println("Topic: " + this.topic);
        System.out.println("Payload: " + this.payload);
        System.out.println(
            "Timestamp: " +
                this.timestamp.format(
                    DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")
                )
        );
    }

    public int getId() {
        return id;
    }
}
