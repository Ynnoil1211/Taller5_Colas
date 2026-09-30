package co.mqtt.queue;
/*
Modificado por:
DANIEL ESTEBAN BORRE CARO - 0222510016
LIONNY LIN LI - 0222510050
MARIA ALEJANDRA RAMOS NAIZIR - 0222510006
 */
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
