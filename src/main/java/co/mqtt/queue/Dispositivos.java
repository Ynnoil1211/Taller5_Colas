package co.mqtt.queue;
import java.time.LocalDateTime;
import java.time.LocalTime;
public class Dispositivos {

    private static final String[][] dispositivos = {
        // Sensor - Topic - Medicion
        { "S01", "iot/sensor01/temperatura", "Temperatura" },
        { "S02", "iot/sensor02/humedad", "Humedad" },
        { "S03", "iot/sensor03/nivel", "Nivel de agua" },
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
            refe[2],
            payload,
            LocalDateTime.now()
        );
        return nuevo;
    }
}
