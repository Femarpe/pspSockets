package ej1;

import java.io.DataInputStream;
import java.net.Socket;

public class Cliente {
    static final String HOST = "localhost";
    static final int PUERTO = 5050;

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
