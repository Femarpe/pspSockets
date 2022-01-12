package ej5;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ClienteTCP {
    static final int PUERTO = 5055;
    static final String HOST = "localhost";

    public static void main(String[] args) {
        try {
            Socket socket = new Socket(HOST, PUERTO);
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            Scanner sc = new Scanner(System.in);

            System.out.println("Introduce numero a enviar ");
            String textoOut = sc.nextLine();
            dataOutputStream.writeUTF(textoOut);

            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());

            String textoIn = dataInputStream.readUTF();
            System.out.println(textoIn);

            socket.close();
        } catch (IOException e) {

        }
    }
}
