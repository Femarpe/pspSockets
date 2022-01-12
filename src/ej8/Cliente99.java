package ej8;

import java.io.DataInputStream;
import java.net.Socket;

public class Cliente99 {
    static final String HOST = "localhost";
    static final int PUERTO = 9997; //utilizo el puerto 9997 por que el 9999 esta en uso

    public static void main(String[] arg) {
        try {
            Socket socket = new Socket(HOST, PUERTO);
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            System.out.println(dataInputStream.readUTF());
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
