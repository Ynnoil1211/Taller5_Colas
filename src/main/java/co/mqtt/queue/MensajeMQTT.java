package co.mqtt.queue;

public class MensajeMQTT {
    int id;
    String dispositivoId;
    String topic;
    String med;
    String payload;
    String timestamp;
    MensajeMQTT(String dispositivoId, String topic, String med, String payload, String timestamp){
        this.dispositivoId = dispositivoId;
        this.topic = topic;
        this.med = med;
        this.payload = payload;
        this.timestamp = timestamp;
    }

    void mostrarMensaje() {
        System.out.println("ID: " + this.id);
        System.out.println("Dispositivo: " + this.dispositivoId);
        System.out.println("Topic: " + this.topic);
        System.out.println("Medición: " + this.med);
        System.out.println("Payload: " + this.payload);
        System.out.println("Timestamp: " + this.timestamp);
    }
}
