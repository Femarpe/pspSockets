package ej3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    static final int PUERTO = 5053;

    public static void main(String[] args) {
        try{
            ServerSocket serverSocket = new ServerSocket(PUERTO);
            System.out.println("funcionando");

            Socket socket = serverSocket.accept();
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());

            String contenidoArchivo = dataInputStream.readUTF();

            System.out.println(contenidoArchivo);


            socket.close();;

        }catch (IOException ex){
            System.out.println("excepción: "+ex.getStackTrace());
        }

    }
}
