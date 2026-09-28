package co.mqtt.queue;

public class ServidorMQTT {
    Mensaje cabeza;
    Mensaje cola;
    int size;
    private int ids;

    public ServidorMQTT(){
        limpiar();
    }
    public void limpiar(){
        cabeza = null;
        cola = null;
        size = 0;
        ids = 0;
    }

    public boolean estaVacio(){
        return size == 0;
    }

    public void encolar(String ref, String payload, String timestamp){
        Mensaje nuevo = Dispositivos.crear(ref,payload,timestamp);
        if (nuevo == null) return;
        nuevo.id = ids++;
        if (cabeza==null){
            cabeza=nuevo;
            cola=nuevo;
        }
        else {
            cola.sig=nuevo;
        }
        cola = nuevo;
        size++;
    }
}
