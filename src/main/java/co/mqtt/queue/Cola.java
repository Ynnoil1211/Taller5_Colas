package co.mqtt.queue;
public class Cola {

    Nodo primerNodo;
    Nodo ultimoNodo;
    int size;
    private int ids;

    public Cola() {
        limpiar();
    }

    void limpiar() {
        primerNodo = null;
        ultimoNodo = null;
        size = 0;
        ids = 1;
    }

    boolean estaVacio() {
        return size == 0;
    }

    boolean encolar(String ref, String payload, String timestamp) {
        MensajeMQTT mensaje = Dispositivos.crear(ref, payload, timestamp);
        if (mensaje == null) return false;
        mensaje.id = ids++;
        Nodo nuevo = Nodo.crearNodo(mensaje);
        if (primerNodo == null) {
            primerNodo = nuevo;
            ultimoNodo = nuevo;
        } else {
            ultimoNodo.sig = nuevo;
        }
        ultimoNodo = nuevo;
        size++;
        return true;
    }

    MensajeMQTT decolar() {
        if(this.estaVacio()) {
            return null;
        };
        Nodo nodoMensaje = this.primerNodo;
        this.primerNodo = this.primerNodo.sig;
        size--;
        return nodoMensaje.getDato();
    }
}
