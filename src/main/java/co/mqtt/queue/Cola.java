package co.mqtt.queue;

public class Cola<T> {

    Nodo<T> primerNodo;
    Nodo<T> ultimoNodo;
    int size = 0;

    public Cola() {
        limpiar();
    }

    private void limpiar() {
        primerNodo = null;
        ultimoNodo = null;
        size = 0;
    }

    public boolean estaVacia() {
        return size == 0;
    }

    public T decolar() {
        if (estaVacia()) {
            return null;
        }
        T aux = primerNodo.getDato();
        primerNodo = primerNodo.sig;
        size--;
        if (primerNodo == null) ultimoNodo = null;
        return aux;
    }

    public boolean encolar(Nodo<T> Nodo) {
        Nodo<T> nuevoNodo = Nodo;
        if (estaVacia()) {
            primerNodo = nuevoNodo;
            ultimoNodo = nuevoNodo;
        } else {
            ultimoNodo.sig = Nodo;
            ultimoNodo = Nodo;
        }
        size++;
        return true;
    }
}
