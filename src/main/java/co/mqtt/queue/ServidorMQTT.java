package co.mqtt.queue;
/*
Elaborado por:
DANIEL ESTEBAN BORRE CARO - 0222510016
LIONNY LIN LI - 0222510050
MARIA ALEJANDRA RAMOS NAIZIR - 0222510006

--Repo en Github del taller https://github.com/danicpr/Taller5_Colas
 */
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
            System.out.println("Nuevo mensaje publicado al servidor");
            nuevo.getDato().mostrarMensaje();
            mostrarEstadoCola();
        } else System.out.println("Referencia no encontrada. ");
    }

    public void mostrarEstadoCola() {
        Nodo<MensajeMQTT> curr = cola.primerNodo;
        System.out.println("Estado Actual de la Cola (Frente -> Final): ");
        if (cola.estaVacia()) System.out.print("Cola Vacia. ");
        else{
            Nodo<MensajeMQTT> aux = curr;
            System.out.print("ID Mensaje: ");
            while (aux != null) {
                System.out.print(aux.getDato().getId());
                if (aux != cola.ultimoNodo) System.out.print(" -> ");
                aux = aux.sig;
            }
            System.out.print("\nDispositivo: ");
            while (curr != null) {
                System.out.print(curr.getDato().getDispositivoId());
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
        System.out.println("--------");
        mostrarEstadoCola();
        System.out.println("--------");
        System.out.println("Mensaje(s) Restante(s): " + cola.size);
    }

    public static int getIds() {
        return ++ids;
    }
}
