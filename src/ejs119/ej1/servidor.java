package ejs119.ej1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class servidor {
    static final int PUERTO = 5057;

    public static void main(String[] args) {
        boolean salida = false;


        try {
            System.out.println("funcionando");
            System.out.println("esperando mensaje");
            ServerSocket serverSocket = new ServerSocket(PUERTO);
            Socket socket;
            do {
                String textoOut = "No es una pregunta valida";
                socket = serverSocket.accept();
                DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());

                String textoIn = dataInputStream.readUTF();
                System.out.println("mensaje recibido: " + textoIn);

                textoIn.contains("?");

                boolean pregunta = false;
                char[] chars = new char[textoIn.length()];
                for (int i = 0; i < textoIn.length(); i++) {
                    chars[i] = textoIn.charAt(i);
                    if (chars[i] == '?') {
                        pregunta = true;
                    }
                }

                if (pregunta) {
                    if (textoIn.toLowerCase().equals("¿como te llamas?")) {
                        textoOut = "Me llamo Ejercicio1";
                    } else if ( textoIn.toLowerCase().equals("¿cuantas lineas de codigo tienes?")){
                        textoOut = "tengo 60 lineas";
                    }
                }
                if (textoIn.toLowerCase().equals("bye")) {
                    textoOut = "Adios";
                    salida = true;
                } else {
                }
                DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
                dataOutputStream.writeUTF(textoOut);

            } while (!salida);
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}