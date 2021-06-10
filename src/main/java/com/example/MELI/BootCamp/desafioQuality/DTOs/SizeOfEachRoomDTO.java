package com.example.MELI.BootCamp.desafioQuality.DTOs;

public class SizeOfEachRoomDTO {
    private String room_name;
    private double roo_size;

    public SizeOfEachRoomDTO(String room_name, double roo_size) {
        this.room_name = room_name;
        this.roo_size = roo_size;
    }

    public String getRoom_name() {
        return room_name;
    }

    public void setRoom_name(String room_name) {
        this.room_name = room_name;
    }

    public double getRoo_size() {
        return roo_size;
    }

    public void setRoo_size(double roo_size) {
        this.roo_size = roo_size;
    }
}
