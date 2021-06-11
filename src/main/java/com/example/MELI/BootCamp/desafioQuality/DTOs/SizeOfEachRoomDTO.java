package com.example.MELI.BootCamp.desafioQuality.DTOs;

import java.util.Objects;

public class SizeOfEachRoomDTO {
    private String room_name;
    private double room_size;

    public SizeOfEachRoomDTO(String room_name, double room_size) {
        this.room_name = room_name;
        this.room_size = room_size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SizeOfEachRoomDTO that = (SizeOfEachRoomDTO) o;
        return Double.compare(that.room_size, room_size) == 0 && Objects.equals(room_name, that.room_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(room_name, room_size);
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
