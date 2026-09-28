package co.mqtt.app;
import co.mqtt.queue.ServidorMQTT;


public class App {
    public static void main(String args[]){
        ServidorMQTT server = new ServidorMQTT();
        server.publicar("S01", "38 °C", "04:20:67");
        server.procesar();
        server.procesar();
        server.publicar("S03", "67cm", "06:06:06");
        server.publicar("S02", "69%", "23:22:23");
        server.publicar("S04", "59N", "23:59:59");
        server.procesar();
        server.procesar();
    }
}
