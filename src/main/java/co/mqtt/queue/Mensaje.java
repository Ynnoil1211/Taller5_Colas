package co.mqtt.queue;

public class Mensaje {
    int id;
    String dispositivoId;
    String topic;
    String payload;
    String timestamp;
    Mensaje sig;
    Mensaje(String dispositivoId, String topic, String payload, String timestamp){
        this.dispositivoId = dispositivoId;
        this.topic = topic;
        this.payload = payload;
        this.timestamp = timestamp;
        this.sig = null;
    }
}
