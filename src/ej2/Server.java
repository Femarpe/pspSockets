package ej2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    static final int PUERTO = 5052;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PUERTO);
            System.out.println("funcionando");

            Socket socket = serverSocket.accept();
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());

            String textoIn = dataInputStream.readUTF();

            String salidatexto = "el texto recibido " + textoIn.length() + " caracteres";

            System.out.println(salidatexto);
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            dataOutputStream.writeUTF(salidatexto);

            socket.close();
        } catch (IOException ex) {
            System.out.println("excepción: " + ex.getStackTrace());
        }

    }
}
