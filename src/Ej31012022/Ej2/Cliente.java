package Ej31012022.Ej2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    static final int PUERTO = 5056;
    static final String HOST = "localhost";

    public static void main(String[] args) {
        boolean salida = false;
        try {
            Scanner sc = new Scanner(System.in);
            Socket socket;
            do {
                socket = new Socket(HOST, PUERTO);
                DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
                System.out.print("Introduce su nombre para comprear entrada: ");
                String textoOut = sc.nextLine();
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
