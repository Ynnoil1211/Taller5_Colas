package co.mqtt.queue;

import java.time.LocalDateTime;
/*
Elaborado por:
DANIEL ESTEBAN BORRE CARO - 0222510016
LIONNY LIN LI - 0222510050
MARIA ALEJANDRA RAMOS NAIZIR - 0222510006

--Repo en Github del taller https://github.com/danicpr/Taller5_Colas
 */
public class Dispositivos {

    private static final String[][] dispositivos = {
        // Sensor - Topic
        { "S01", "iot/sensor01/temperatura" },
        { "S02", "iot/sensor02/humedad" },
        { "S03", "iot/sensor03/nivel" },
    };

    private static String[] buscar(String ref) {
        for (String[] fila : dispositivos) {
            if (fila[0].equalsIgnoreCase(ref)) {
                return fila;
            }
        }
        return null;
    }

    static MensajeMQTT crear(String ref, String payload) {
        String[] refe = buscar(ref);
        if (refe == null) return null;
        MensajeMQTT nuevo = new MensajeMQTT(
            ServidorMQTT.getIds(),
            refe[0],
            refe[1],
            payload,
            LocalDateTime.now()
        );
        return nuevo;
    }
}
