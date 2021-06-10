package com.example.MELI.BootCamp.desafioQuality.service;

import com.example.MELI.BootCamp.desafioQuality.DTOs.SizeOfEachRoomDTO;
import com.example.MELI.BootCamp.desafioQuality.model.Property;
import java.util.List;

public interface RoomCalculatorService {
    String getBiggestRoom(Property property);

    List<SizeOfEachRoomDTO> getSizeOfEachRoom(Property property);
}
