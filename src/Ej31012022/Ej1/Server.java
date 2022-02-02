package Ej31012022.Ej1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    static final int PUERTO = 5053;

    public static void main(String[] args) {
        try{
            ServerSocket serverSocket = new ServerSocket(PUERTO);
            System.out.println("funcionando");

            Socket socket = serverSocket.accept();

            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());

            byte[] bytes = new byte[1024];

            dataInputStream.read(bytes);

            System.out.println(bytes);

            String nombreFichero = "src\\recusos\\PruebaSalida.txt";
            try (FileOutputStream fos = new FileOutputStream(nombreFichero)) {
                fos.write(bytes);
            }
            socket.close();

        }catch (IOException ex){
            System.out.println("excepción: "+ex.getStackTrace());
        }

    }
}
