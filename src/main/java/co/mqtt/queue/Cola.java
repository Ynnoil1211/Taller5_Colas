package co.mqtt.queue;

public class Cola {

    Nodo primerNodo;
    Nodo ultimoNodo;
    int size;
    private int ids;

    public Cola() {
        limpiar();
    }

    public void limpiar() {
        primerNodo = null;
        ultimoNodo = null;
        size = 0;
        ids = 1;
    }

    public boolean estaVacio() {
        return size == 0;
    }

    public void encolar(String ref, String payload, String timestamp) {
        MensajeMQTT mensaje = Dispositivos.crear(ref, payload, timestamp);
        Nodo nuevo = Nodo.crearNodo(mensaje);
        if (nuevo == null) return;
        nuevo.id = ids++;
        if (primerNodo == null) {
            primerNodo = nuevo;
            ultimoNodo = nuevo;
        } else {
            ultimoNodo.sig = nuevo;
        }
        ultimoNodo = nuevo;
        size++;
    }

    public void decolar() {
        if(this.estaVacio()) {
            System.out.println("El Servidor esta vacio. ");
            return;
        };
        Nodo mensaje = this.primerNodo;
        mensaje.mostrarNodoMensaje();
        this.primerNodo = primerNodo.sig;
        size--;
        System.out.println("Mensaje(s) Restante(s): " + this.size);
    }
}
