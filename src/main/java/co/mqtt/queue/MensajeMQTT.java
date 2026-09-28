package co.mqtt.queue;

public class MensajeMQTT {

    String dispositivoId;
    String topic;
    String payload;
    String timestamp;
    MensajeMQTT(String dispositivoId, String topic, String payload, String timestamp){
        this.dispositivoId = dispositivoId;
        this.topic = topic;
        this.payload = payload;
        this.timestamp = timestamp;
    }

    public String getDispositivoId() {
        return dispositivoId;
    }

    public String getTopic() {
        return topic;
    }

    public String getPayload() {
        return payload;
    }

    public String getTimestamp() {
        return timestamp;
    }
}
