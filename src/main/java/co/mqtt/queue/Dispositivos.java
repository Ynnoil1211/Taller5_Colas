package co.mqtt.queue;

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

    static MensajeMQTT crear(String ref, String payload, String timestamp) {
        String[] refe = buscar(ref);
        if (refe == null) return null;
        MensajeMQTT nuevo = new MensajeMQTT(
            refe[0],
            refe[1],
            payload,
            timestamp
        );
        return nuevo;
    }
}
