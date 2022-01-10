package ej3;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    static final int PUERTO = 5053;
    static final String HOST = "localhost";

    public static void main(String[] args) {
        try {
            Socket socket = new Socket(HOST, PUERTO);
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            Scanner sc = new Scanner(System.in);


            String nombreFichero = "src\\recusos\\Prueba.txt";
            BufferedReader reader = new BufferedReader(new FileReader(nombreFichero));
            String linea;

            String textoOut = "";

            while ((linea = reader.readLine()) != null) {
                textoOut += linea;
            }
            reader.close();

            dataOutputStream.writeUTF(textoOut);

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
