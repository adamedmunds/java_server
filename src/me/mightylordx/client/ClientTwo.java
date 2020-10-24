package me.mightylordx.client;

import me.mightylordx.server.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientTwo {





    public void sendPacket(String message) throws IOException {
        System.out.println("Connecting to 127.0.0.1 on port " + Server.PORT + " (http://127.0.0.1:6969)");
        Socket socket = new Socket("127.0.0.1", Server.PORT);

        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
        output.println(message);
        String response = input.readLine();

        System.out.println(response);

        socket.close();

    }
}
