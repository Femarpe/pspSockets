package ej8;

import javax.imageio.IIOException;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Server {



    public static void main(String[] args) {
        new HiloServer1().start();
        new HiloServer2().start();
    }
}

class HiloServer1 extends Thread {
    static final int PUERTO = 9998;

    @Override
    public void run() {
        boolean salida = false;


        try {
            System.out.println("funcionando");
            System.out.println("esperando mensaje");
            ServerSocket serverSocket1 = new ServerSocket(PUERTO);

            Socket socket;
            do {
                socket = serverSocket1.accept();
                DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());

                String textoIn = dataInputStream.readUTF();
                System.out.println("mensaje recibido: " + textoIn);

                if (textoIn.toLowerCase().equals("bye")) {
                    salida = true;
                } else {
                }
                DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
                dataOutputStream.writeUTF(textoIn);

            } while (!salida);
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
class HiloServer2 extends Thread {
    static final int PUERTO = 9997; //utilizo el puerto 9997 por que el 9999 esta en uso

    @Override
    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(PUERTO);
            System.out.println("funcionando");

            Socket socket = serverSocket.accept();

            Date date=java.util.Calendar.getInstance().getTime();
            String salidatexto = date.toString();

            System.out.println(salidatexto);
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            dataOutputStream.writeUTF(salidatexto);

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}