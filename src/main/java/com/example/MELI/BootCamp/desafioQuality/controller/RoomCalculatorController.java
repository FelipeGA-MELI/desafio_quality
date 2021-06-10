package com.example.MELI.BootCamp.desafioQuality.controller;

import com.example.MELI.BootCamp.desafioQuality.DTOs.SizeOfEachRoomDTO;
import com.example.MELI.BootCamp.desafioQuality.model.Property;
import com.example.MELI.BootCamp.desafioQuality.service.RoomCalculatorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/room")
public class RoomCalculatorController {
    RoomCalculatorService roomCalculatorService;

    public RoomCalculatorController(RoomCalculatorService roomCalculatorService) {
        this.roomCalculatorService = roomCalculatorService;
    }

    @PostMapping("/biggest")
    public ResponseEntity<String> getBiggestRoom(@RequestBody @Valid Property property) {
        return new ResponseEntity<>(roomCalculatorService.getBiggestRoom(property),HttpStatus.OK);
    }

    @PostMapping("/sizeOfEach")
    public ResponseEntity<List<SizeOfEachRoomDTO>> getSizeOfEachRoom(@RequestBody @Valid Property property) {
        return new ResponseEntity<>(roomCalculatorService.getSizeOfEachRoom(property),HttpStatus.OK);
    }
}
