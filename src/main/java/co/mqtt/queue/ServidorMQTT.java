package co.mqtt.queue;

public class ServidorMQTT {

    Cola<MensajeMQTT> cola;
    private static int ids = 0;

    public ServidorMQTT() {
        cola = new Cola<MensajeMQTT>();
    }

    public void publicar(String ref, String payload) {
        MensajeMQTT mensaje = Dispositivos.crear(ref, payload);
        Nodo<MensajeMQTT> nuevo =
            mensaje != null ? new Nodo<MensajeMQTT>(mensaje) : null;
        if (nuevo != null) {
            cola.encolar(nuevo);
            System.out.println(
                "Mensaje enviado con Id: " + nuevo.getDato().getId()
            );
            mostrarEstadoCola();
        } else System.out.println("Referencia no encontrada. ");
    }

    public void mostrarEstadoCola() {
        Nodo<MensajeMQTT> curr = cola.primerNodo;
        System.out.println("Estado Actual de la Cola: ");
        if (cola.estaVacia()) System.out.print("Cola Vacia. ");
        else{
            System.out.print("ID: ");
            while (curr != null) {
                System.out.print(curr.getDato().getId());
                if (curr != cola.ultimoNodo) System.out.print(" -> ");
                curr = curr.sig;
            }
        }
        System.out.println();
    }

    public void procesar() {
        MensajeMQTT primerMensaje = cola.decolar();
        if (primerMensaje == null) {
            System.out.println("No quedan mensajes en la cola");
            return;
        }
        System.out.println("Mensaje Procesado: ");
        primerMensaje.mostrarMensaje();
        mostrarEstadoCola();
        System.out.println("Mensaje(s) Restante(s): " + cola.size);
    }

    public static int getIds() {
        return ++ids;
    }
}
