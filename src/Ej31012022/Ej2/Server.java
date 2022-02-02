package Ej31012022.Ej2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
    static final int PUERTO = 5056;


    public static void main(String[] args) {
        boolean salida = false;
        List<String> nombresEntradas = new ArrayList<>();

        try {
            System.out.println("funcionando");
            System.out.println("esperando mensaje");
            ServerSocket serverSocket = new ServerSocket(PUERTO);
            Socket socket;
            do {
                socket = serverSocket.accept();
                DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());

                String textoIn = dataInputStream.readUTF();
                System.out.println("mensaje recibido: " + textoIn);

                String textoOut = "";

                if (textoIn.toLowerCase().equals("bye")) {
                    salida = true;
                } else if (new Server().isInside(nombresEntradas, textoIn)) {
                    textoOut = "Usted ya ha adquirido una entrada, no puede adquirir mas a su nombre";
                } else {
                    nombresEntradas.add(textoIn);
                    textoOut = "Entrada nº:" + nombresEntradas.size();
                }
                DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
                dataOutputStream.writeUTF(textoOut);

            } while (!salida);
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public boolean isInside(List<String> lNombres, String nombre) {
        boolean inside = false;
        for (int i = 0; i < lNombres.size(); i++) {
            if (lNombres.get(i).toLowerCase().equals(nombre.toLowerCase())) {
                inside = true;
            }
        }
        return inside;
    }
}
