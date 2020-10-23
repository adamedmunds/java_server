package me.mightylordx.server;

import me.mightylordx.utils.Packet;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {


    public static final int PORT = 6969;
    private ServerSocket serverSocket;

    public Server() throws IOException {
         serverSocket = new ServerSocket(PORT);

        System.out.println("Waiting for client on port " +
                serverSocket.getLocalPort() + "...");
    }


    public void getSocket() {
        while (true) {
            try {
                Socket server = serverSocket.accept();
                System.out.println("Client Connected on port: " +  +server.getLocalPort());

                ObjectOutputStream objectOutputStream = new ObjectOutputStream(server.getOutputStream());
                ObjectInputStream objectInputStream = new ObjectInputStream(server.getInputStream());

                Packet clientPacket = (Packet)objectInputStream.readObject();
                Packet serverPacket;

                if (clientPacket.getMessage().equals("Hello There Server!")) {
                    serverPacket = new Packet("Hello There Client!");
                } else if (clientPacket.getMessage().equals("Fuck you Server!")) {
                    serverPacket = new Packet("Fuck you too Client!");
                } else {
                    serverPacket = new Packet("Oh didn't say anything I want okay :(");
                }
                objectOutputStream.writeObject(serverPacket);

                server.close();

            } catch (Exception e) {
                System.out.println("Something went wrong " + e);
            }
        }
    }

}
