package com.example.MELI.BootCamp.desafioQuality.unit;

import com.example.MELI.BootCamp.desafioQuality.DTOs.SizeOfEachRoomDTO;
import com.example.MELI.BootCamp.desafioQuality.model.Property;
import com.example.MELI.BootCamp.desafioQuality.model.Room;
import com.example.MELI.BootCamp.desafioQuality.service.RoomCalculatorService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.LinkedList;
import java.util.List;

@SpringBootTest
public class RoomCalculatorServiceTest {
    @Autowired
    private RoomCalculatorService roomCalculatorService;

    private Property property;
    private List<SizeOfEachRoomDTO> sizeOfEachRoomListExpected;

    @BeforeEach
    void setup() {
       configureProperty();
       configureSizeOfEachRoomList();
    }

    private void configureProperty() {
        List<Room> roomList = new LinkedList<>();

        roomList.add(new Room("Cozinha",10.0,5.0));
        roomList.add(new Room("Quarto",5.0,5.0));
        roomList.add(new Room("Sala",20.0,10.0));

        property = new Property("TestePropriedade","marambaia",roomList);
    }

    private void configureSizeOfEachRoomList() {
        sizeOfEachRoomListExpected = new LinkedList<>();

        sizeOfEachRoomListExpected.add(new SizeOfEachRoomDTO("Cozinha",50.0));
        sizeOfEachRoomListExpected.add(new SizeOfEachRoomDTO("Quarto",25.0));
        sizeOfEachRoomListExpected.add(new SizeOfEachRoomDTO("Sala",200.0));
    }

    @Test
    public void shouldReturnBiggestRoom() {
        String biggestRoom = roomCalculatorService.getBiggestRoom(property);

        Assertions.assertEquals("Sala",biggestRoom);
    }

    @Test
    public void shouldReturnListOfRoomsSizes() {
        List<SizeOfEachRoomDTO> sizeOfEachRoomListResult = roomCalculatorService.getSizeOfEachRoom(property);

        Assertions.assertEquals(sizeOfEachRoomListExpected, sizeOfEachRoomListResult);
    }
}
