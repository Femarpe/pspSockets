package Ej31012022.Ej1;

import java.io.*;
import java.net.Socket;
import java.nio.file.Files;
import java.util.Scanner;

public class Cliente {
    static final int PUERTO = 5053;
    static final String HOST = "localhost";

    public static void main(String[] args) {
        try {
            Socket socket = new Socket(HOST, PUERTO);
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            Scanner sc = new Scanner(System.in);


            String nombreFichero = "src\\recusos\\Prueba.txt";
            File file = new File(nombreFichero);

            long length = file.length();
            if (length > Integer.MAX_VALUE) {
                System.out.println("File is too large.");
            }

            byte[] buffer =  Files.readAllBytes(file.toPath());

                dataOutputStream.write(buffer);


            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
