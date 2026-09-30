package co.mqtt.queue;
import java.time.LocalDateTime;
public class Dispositivos {

    private static final String[][] dispositivos = {
        // Sensor - Topic - Medicion
        { "S01", "iot/sensor01/temperatura"},
        { "S02", "iot/sensor02/humedad"},
        { "S03", "iot/sensor03/nivel"},
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
