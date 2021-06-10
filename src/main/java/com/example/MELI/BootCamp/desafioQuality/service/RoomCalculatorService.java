package com.example.MELI.BootCamp.desafioQuality.service;

import com.example.MELI.BootCamp.desafioQuality.DTOs.SizeOfEachRoomDTO;
import com.example.MELI.BootCamp.desafioQuality.model.Property;

public interface RoomCalculatorService {
    String getBiggestRoom(Property property);

    SizeOfEachRoomDTO getSizeOfEachRoom(Property property);
}
