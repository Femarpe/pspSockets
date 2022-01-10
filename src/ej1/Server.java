package ej1;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    static final int PUERTO = 5050;

    public static void main(String[] arg) {
        int nClientes = 1;
        int maxClinete = 3;
        boolean salir = false;
        try {
            ServerSocket serverSocket = new ServerSocket(PUERTO);
            System.out.println("funcionando");
            do {
                Socket socket = serverSocket.accept();
                DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
                dataOutputStream.writeUTF("Hola cliente " + nClientes);
                dataOutputStream.close();
                System.out.println("Cliente " + nClientes + " saludado");
                nClientes++;

                if (nClientes == maxClinete) {
                    salir = true;
                }
            } while (salir == true);
            serverSocket.close();
            System.out.println("Atendidos " + maxClinete + ", cerrando");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
