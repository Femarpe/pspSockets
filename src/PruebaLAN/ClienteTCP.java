package PruebaLAN;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ClienteTCP {
    static final int PUERTO = 8070;
    //static final String HOST = "192.168.5.2";
    static final String HOST = "192.168.5.208";
    //static final int PUERTO = 5057;
    //static final String HOST = "localhost";
    public static void main(String[] args) {
        boolean salida = false;
        try {
            Scanner sc = new Scanner(System.in);
            Socket socket;
            System.out.print("Introduce una cadena: ");
            String textoOut = sc.nextLine();
            socket = new Socket(HOST, PUERTO);
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            dataOutputStream.writeUTF(textoOut);


            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            String textoIn = dataInputStream.readUTF();
            System.out.println(textoIn);


            socket.close();
        } catch (IOException e) {

        }
    }
}
