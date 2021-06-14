package com.example.MELI.BootCamp.desafioQuality.service;

import com.example.MELI.BootCamp.desafioQuality.DTOs.SizeOfEachRoomDTO;
import com.example.MELI.BootCamp.desafioQuality.model.Property;
import com.example.MELI.BootCamp.desafioQuality.model.Room;
import org.springframework.stereotype.Service;
import java.util.LinkedList;
import java.util.List;

@Service
public class RoomCalculatorServiceImpl implements RoomCalculatorService{
    @Override
    public String getBiggestRoom(Property property) {
        List<Room> roomList = property.getProp_rooms();
        double biggestSize = 0.0;
        String biggestRoom = "";

        for(Room room: roomList) {
            double roomSize = room.getRoom_width() * room.getRoom_length();

            if(roomSize > biggestSize) {
                biggestRoom = room.getRoom_name();
                biggestSize = roomSize;
            }
        }

        return biggestRoom;
    }

    @Override
    public List<SizeOfEachRoomDTO> getSizeOfEachRoom(Property property) {
        List<SizeOfEachRoomDTO> sizeOfEachRoomDTOList = new LinkedList<>();
        List<Room> roomList = property.getProp_rooms();

        for(Room room: roomList) {
            double roomSize = room.getRoom_width() * room.getRoom_length();
            sizeOfEachRoomDTOList.add(new SizeOfEachRoomDTO(room.getRoom_name(),roomSize));
        }

        return sizeOfEachRoomDTOList;
    }
}
