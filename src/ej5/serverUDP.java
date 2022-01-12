package ej5;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class serverUDP {
    public static void main(String[] args) {

        int PUERTO = 5055; //poner un puerto que no esté usado, los primeros suelen estar usados
            //buffer para manejar el mensaje - los paquetes que van a ir de un lado a otro, los datagramas
        byte[] buffer = new byte[1024];

        try {
            System.out.println("Iniciado el servidor UDP");
                //Un cliente es el que envía datagramas (mensajes) al servidor
                //Creacion del socket
                //El servidor indica que está escuchando en un puerto en concreto
            DatagramSocket socketUDP = new DatagramSocket(PUERTO);

            while (true) {
                    //Preparo la respuesta
                    //Datagramas que vamos a enviar y recibir
                    //establecemos un tamaño máximo a los datagramas que lleguen mediante esta clase
                DatagramPacket peticion = new DatagramPacket(buffer, buffer.length);

                    //El servidor espera a que llegue alguna petición
                socketUDP.receive(peticion);
                    //se recibe un paquete de datagram (petición) del cliente
                System.out.println("Recibo la información del cliente");

                    //Cogemos el mensaje que nos ha mandado el cliente:
                String mensaje = new String(peticion.getData());
                    //Convierto lo recibido y mostrar el mensaje
                System.out.println(mensaje);

                    //inicialmente en UDP no sabemos quién nos ha contactado.
                    //Si queremos contestarle, hay que conseguir la dirección y el puerto del cliente
                    // que ha contactado para poder contestarle
                int puertoCliente = peticion.getPort();
                InetAddress direccion = peticion.getAddress();

                    //mensaje que enviamos a su vez al cliente
                mensaje = "Hola mundo desde el servidor";
                buffer = mensaje.getBytes();

                    //Creamos otro paquete para la respuesta del servidor al cliente - datagrama
                DatagramPacket respuesta = new DatagramPacket(buffer, buffer.length, direccion, puertoCliente);
                System.out.println("Envío información al cliente");
                    //se le envía al cliente
                socketUDP.send(respuesta);
            }

        } catch (
                IOException e) {
            System.out.println(e.getStackTrace());
        }


    }
}
