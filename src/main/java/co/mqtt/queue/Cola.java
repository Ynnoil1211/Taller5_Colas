package co.mqtt.queue;
public class Cola {

    Nodo primerNodo;
    Nodo ultimoNodo;
    int size;
    public Cola() {
        limpiar();
    }

    void limpiar() {
        primerNodo = null;
        ultimoNodo = null;
        size = 0;
    }

    boolean estaVacio() {
        return size == 0;
    }

    boolean encolar(MensajeMQTT mensaje) {
        Nodo nuevo = Nodo.crearNodo(mensaje);
        if (primerNodo == null) {
            primerNodo = nuevo;
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
        if(this.primerNodo == this.ultimoNodo) this.ultimoNodo = null;
        this.primerNodo = this.primerNodo.sig;
        size--;
        return nodoMensaje.getDato();
    }

    void mostrarEstadoCola(){
        System.out.println("Contenido Cola: ");
        Nodo curr = this.primerNodo;
        while(curr!=null) {
            System.out.print("Id: " + curr.getDato().getId());
            if(curr!=ultimoNodo) System.out.print(" -> ");
            curr = curr.sig;
        }
        if(this.estaVacio()) System.out.print("Cola Vacia. ");
        System.out.println();
    }
}
