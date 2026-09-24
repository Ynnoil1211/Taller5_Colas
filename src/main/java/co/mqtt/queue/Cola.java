package co.mqtt.queue;

public class Cola <T>{
    Nodo<T> primerNodo;
    Nodo<T> ultimoNodo;
    int size = 0;
	
    public Cola(){
        limpiar();
    }

    private void limpiar(){
        primerNodo = null;
        ultimoNodo = null;
        size = 0;
    }

    public boolean estaVacia(){
        return size==0;
    }
    public T decolar(){
        T aux=null;
        if(!estaVacia()){
            aux = primerNodo.getDato();
            primerNodo = primerNodo.sig;
            size = size - 1;
        }
        else System.out.println("La Cola esta vacia");
        return aux;
    }
    public boolean encolar(Nodo<T> Nodo){
        Nodo<T> nuevoNodo = Nodo;
        if(estaVacia()){
            primerNodo = nuevoNodo;
            ultimoNodo = nuevoNodo;
        }
        else{
            ultimoNodo.sig = Nodo;
            ultimoNodo= Nodo;
        }
        size=size+1;
        return true;
    }
        
}
