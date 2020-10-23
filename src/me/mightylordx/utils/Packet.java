package me.mightylordx.utils;

import java.io.Serializable;

public class Packet implements Serializable {


    private final String message;

    public Packet(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
