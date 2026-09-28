package co.mqtt.queue;

public class Nodo {
    int id;
    MensajeMQTT dato;
    Nodo sig;

    private Nodo(MensajeMQTT dato) {
        this.dato = dato;
        this.sig = null;
    }

    public static Nodo crearNodo(MensajeMQTT dato){
        if(dato == null) return null;
        Nodo nuevo = new Nodo(dato);
        return nuevo;
    }

    public Nodo(MensajeMQTT dato, Nodo sig) {
        this.dato = dato;
        this.sig = sig;
    }

    public MensajeMQTT getDato() {
        return this.dato;
    }

    public void mostrarNodoMensaje() {
        System.out.println("ID: " + this.id);
        System.out.println("Dispositivo: " + dato.getDispositivoId());
        System.out.println("Topic: " + dato.getTopic());
        System.out.println("Payload: " + dato.getPayload());
        System.out.println("Timestamp: " + dato.getTimestamp());
    }

}
