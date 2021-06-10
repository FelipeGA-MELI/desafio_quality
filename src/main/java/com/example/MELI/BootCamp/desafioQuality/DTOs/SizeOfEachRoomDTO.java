package com.example.MELI.BootCamp.desafioQuality.DTOs;

public class SizeOfEachRoomDTO {
    private String room_name;
    private double room_size;

    public SizeOfEachRoomDTO(String room_name, double room_size) {
        this.room_name = room_name;
        this.room_size = room_size;
    }

    public String getRoom_name() {
        return room_name;
    }

    public void setRoom_name(String room_name) {
        this.room_name = room_name;
    }

    public double getRoom_size() {
        return room_size;
    }

    public void setRoom_size(double room_size) {
        this.room_size = room_size;
    }
}
