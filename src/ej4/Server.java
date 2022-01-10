package ej4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    static final int PUERTO = 5054;

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

                if (textoIn.toLowerCase().equals("hola")) {
                    System.out.println("respondiendo");
                    String salidatexto = "¿Que tal?";
                    DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                    out.writeUTF(salidatexto);
                    salida = true;
                } else {
                    DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
                    dataOutputStream.writeUTF("-");
                    System.out.println("no se responde");
                }

            } while (salida == false);
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();        }


    }
}
