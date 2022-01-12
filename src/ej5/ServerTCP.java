package ej5;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTCP {
    static final int PUERTO = 5055;

    public static void main(String[] args) {


        try {
            ServerSocket serverSocket = new ServerSocket(PUERTO);
            System.out.println("funcionando");

            Socket socket = serverSocket.accept();
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());

            String textoIn = dataInputStream.readUTF();

            String salidatexto = "";
            try {
                int numeroIn = Integer.parseInt(textoIn);
                int numeroOut = numeroIn * numeroIn;
                salidatexto = "el cuadrado de " + numeroIn + " es: " + numeroOut;
            } catch (Exception e) {
                salidatexto = "Solo se aceptan valores numericos";
            }


            System.out.println(salidatexto);
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            dataOutputStream.writeUTF(salidatexto);

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
