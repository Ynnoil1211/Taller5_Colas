package co.mqtt.queue;
/*
Modificado por:
DANIEL ESTEBAN BORRE CARO - 0222510016
LIONNY LIN LI - 0222510050
MARIA ALEJANDRA RAMOS NAIZIR - 0222510006
 */
public class Nodo<T> {

    T dato;
    Nodo<T> sig;

    public Nodo(T dato) {
        this.dato = dato;
        this.sig = null;
    }

    public Nodo(T dato, Nodo<T> sig) {
        this.dato = dato;
        this.sig = sig;
    }

    public T getDato() {
        return this.dato;
    }
}
