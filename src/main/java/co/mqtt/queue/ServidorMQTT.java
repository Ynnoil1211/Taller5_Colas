package co.mqtt.queue;

public class ServidorMQTT {
    Cola cola;
    ServidorMQTT(){
        cola = new Cola();
    }
    public void publicar(String ref, String payload, String timestamp){
        if(cola.encolar(ref,payload,timestamp)) System.out.println("Mensaje Publicado. ");
         else  System.out.println("Referencia no encontrada. ");
    }

    public void procesar(){
        MensajeMQTT primerMensaje = cola.decolar();
        System.out.println("Mensaje Procesado: ");
        primerMensaje.mostrarMensaje();
        System.out.println("Mensaje(s) Restante(s): " + cola.getSize());
    }
}
