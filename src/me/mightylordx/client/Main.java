package me.mightylordx.client;

public class Main {

    public static void main(String[] args) throws Exception {
        ClientTwo c = new ClientTwo();
        c.sendPacket("Hello There Server!");
//        c.sendPacket("Fuck you Server!");
        c.sendPacket("Testing");
    }

}
