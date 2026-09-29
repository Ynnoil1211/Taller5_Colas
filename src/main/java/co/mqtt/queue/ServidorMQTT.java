package co.mqtt.queue;

public class ServidorMQTT {
    Cola cola;
    private static int ids = 0;
    public ServidorMQTT(){
        cola = new Cola();
    }
    public void publicar(String ref, String payload){
        MensajeMQTT mensaje = Dispositivos.crear(ref, payload);
        if(mensaje != null){
            cola.encolar(mensaje);
            System.out.println("Mensaje enviado con Id: " + mensaje.getId());
            cola.mostrarEstadoCola();
        }
         else  System.out.println("Referencia no encontrada. ");
    }

    public void procesar(){
        MensajeMQTT primerMensaje = cola.decolar();
        if(primerMensaje == null) {
            System.out.println("No quedan mensajes en la cola");
            return;
        }
        System.out.println("Mensaje Procesado: ");
        primerMensaje.mostrarMensaje();
        cola.mostrarEstadoCola();
        System.out.println("Mensaje(s) Restante(s): " + cola.size);
    }

    public static int getIds() {
        return ++ids;
    }
}
