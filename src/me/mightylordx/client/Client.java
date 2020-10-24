package me.mightylordx.client;

import me.mightylordx.server.Server;
import me.mightylordx.utils.Packet;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client {


    public Client() {


    }

    public void sendPacket(String packetMessage) throws Exception {
        System.out.println("Creating Client Object");


        System.out.println("Connecting to 127.0.0.1 on port " + Server.PORT + " (http://127.0.0.1:6969)");
        Socket socket = new Socket("127.0.0.1", Server.PORT);


        ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());

        Packet clientPacket = new Packet(packetMessage);

        objectOutputStream.writeObject(clientPacket);

        Packet serverPacket = (Packet) objectInputStream.readObject();
        System.out.println(serverPacket.getMessage());

        socket.close();
    }

}
