package PruebaLAN;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ClienteUDP {
    static final int PUERTO = 8070;
    static final String HOST = "192.168.5.2";
    public static void main(String[] args) {




        byte[] buffer = new byte[1024];

        try {
            System.out.println("Iniciado el servidor UDP");

            DatagramSocket socketUDP = new DatagramSocket(PUERTO);


                DatagramPacket peticion = new DatagramPacket(buffer, buffer.length);


                int puertoCliente = peticion.getPort();

            String mensaje = "Hola mundo";
            buffer = mensaje.getBytes();
                DatagramPacket respuesta = new DatagramPacket(buffer, buffer.length, InetAddress.getByName(HOST), PUERTO);
                System.out.println("Envío información al cliente");
                socketUDP.send(respuesta);


        } catch (
                IOException e) {
            System.out.println(e.getStackTrace());
        }


    }
}
