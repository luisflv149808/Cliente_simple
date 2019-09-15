package clientesimple;

import java.net.*;
import java.io.*;



public class ClienteSimple {

    public static void main(String[] args) {

        if (args.length == 3) {
            Socket socket = null;

            if (Metodos.ValidarIp(args[0])) {
                if (Metodos.Numerico(args[1])) {
                    try {
                        if (args[1] != null) {
                            socket = new Socket(args[0].toString(), Integer.parseInt(args[1]));
                        } else {
                            System.out.println("Puerto vacio");
                        }

                    } catch (IOException e) {
                        System.out.println("error al crear el socket " + e.toString());
                        System.exit(1);
                    }
                    PrintWriter escritor = null;

                    try {
                        escritor = new PrintWriter(
                                socket.getOutputStream(), true);
                        escritor.println(args[2]);
                    } catch (IOException e) {
                        System.out.println("Error al mandar info " + e.toString());
                        System.exit(2);
                    }

                    try {
                        socket.getOutputStream().flush();
                        socket.getOutputStream().close();
                        socket.close();
                    } catch (IOException e) {
                        System.out.println("Error al cerrar" + e);
                        System.exit(3);
                    }
                } else {
                    System.out.println("!!Error!!. Ingresa un puerto válido");
                }
            } else {
                System.out.println("Dirección IP Inválida");
                System.exit(0);
            }

        } else {
            System.out.println("!!Error!!. Ingresa todos los argumentos");
        }

    }

}
