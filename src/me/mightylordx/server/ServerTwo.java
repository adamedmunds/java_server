package me.mightylordx.server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTwo {

    public static final int PORT = 6969;
    private final ServerSocket serverSocket;

    public ServerTwo() throws Exception {
        serverSocket = new ServerSocket(PORT);

        System.out.println("Waiting for client on port " +
                serverSocket.getLocalPort() + "...");
    }

    public void getSocket() {
        while (true) {
            try {

                Socket server = serverSocket.accept();
                System.out.println("Client Connected on port: " + server.getLocalPort());


                BufferedReader input = new BufferedReader(new InputStreamReader(server.getInputStream()));
                PrintWriter output = new PrintWriter(server.getOutputStream(), true);
                String response = input.readLine();
                System.out.println("Client sent: " + response);

                if (response.equals("Hi")) {
                    output.println("Hi there client");
                } else {
                    output.println("Hello There Python");
                }
                server.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
