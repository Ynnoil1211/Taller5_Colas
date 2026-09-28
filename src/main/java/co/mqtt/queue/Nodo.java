package co.mqtt.queue;

public class Nodo {

    MensajeMQTT dato;
    Nodo sig;

    private Nodo(MensajeMQTT dato) {
        this.dato = dato;
        this.sig = null;
    }

    static Nodo crearNodo(MensajeMQTT dato){
        if(dato == null) return null;
        Nodo nuevo = new Nodo(dato);
        return nuevo;
    }

    MensajeMQTT getDato() {
        return this.dato;
    }

}
