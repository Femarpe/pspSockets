package ej7;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Cliente1 {
    static final int PUERTO = 5057;
    static final String HOST = "localhost";

    public static void main(String[] args) {
        boolean salida = false;
        try {
            Scanner sc = new Scanner(System.in);
            Socket socket;
            do {
                System.out.print("Introduce una cadena: ");
                String textoOut = sc.nextLine();
                socket = new Socket(HOST, PUERTO);
                DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
                dataOutputStream.writeUTF(textoOut);


                DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
                String textoIn = dataInputStream.readUTF();
                System.out.println(textoIn);
                if (textoIn.toLowerCase().equals("bye")) {
                    salida = true;
                } else {
                }

            } while (!salida);

            socket.close();
        } catch (IOException e) {

        }
    }
}
