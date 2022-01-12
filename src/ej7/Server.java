package ej7;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    static final int PUERTO = 5057;
    public static void main(String[] args) {
        boolean salida = false;


        try {
            System.out.println("funcionando");
            System.out.println("esperando mensaje");
            ServerSocket serverSocket = new ServerSocket(PUERTO);
            Socket socket;
            do {
                socket = serverSocket.accept();
                DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());

                String textoIn = dataInputStream.readUTF();
                System.out.println("mensaje recibido: " + textoIn);

                if (textoIn.toLowerCase().equals("bye")) {
                    salida = true;
                } else {
                }
                DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
                dataOutputStream.writeUTF(textoIn);

            } while (!salida);
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
