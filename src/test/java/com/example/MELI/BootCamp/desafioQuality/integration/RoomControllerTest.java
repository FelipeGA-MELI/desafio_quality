package com.example.MELI.BootCamp.desafioQuality.integration;

import com.example.MELI.BootCamp.desafioQuality.DTOs.SizeOfEachRoomDTO;
import com.example.MELI.BootCamp.desafioQuality.model.Property;
import com.example.MELI.BootCamp.desafioQuality.model.Room;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import java.util.LinkedList;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
public class RoomControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    private Property property;
    private List<SizeOfEachRoomDTO> sizeOfEachRoomDTOList;

    @BeforeEach
    void setup() {
        propertyConfiguration();
        sizeOfEachRoomConfiguration();
    }

    private void propertyConfiguration() {
        List<Room> roomList = new LinkedList<>();

        roomList.add(new Room("Cozinha",10.0,5.0));
        roomList.add(new Room("Quarto",5.0,5.0));
        roomList.add(new Room("Sala",20.0,10.0));

        property = new Property("TestePropriedade","marambaia",roomList);
    }

    private void sizeOfEachRoomConfiguration() {
        sizeOfEachRoomDTOList = new LinkedList<>();

        SizeOfEachRoomDTO sizeOfEachRoomDTO1 = new SizeOfEachRoomDTO("Cozinha",50.0);
        SizeOfEachRoomDTO sizeOfEachRoomDTO2 = new SizeOfEachRoomDTO("Quarto",25.0);
        SizeOfEachRoomDTO sizeOfEachRoomDTO3 = new SizeOfEachRoomDTO("Sala",200.0);

        sizeOfEachRoomDTOList.add(sizeOfEachRoomDTO1);
        sizeOfEachRoomDTOList.add(sizeOfEachRoomDTO2);
        sizeOfEachRoomDTOList.add(sizeOfEachRoomDTO3);
    }

    @Test
    public void shouldReturnBiggestRoom() throws Exception {
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/room/biggest")
                .contentType(MediaType.APPLICATION_JSON_VALUE).accept(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8").content(this.mapper.writeValueAsBytes(property));

        mockMvc.perform(builder).andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Sala"));
    }

    @Test
    public void shouldReturnSizeOfEachRoom() throws Exception {
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/room/sizeOfEach")
                .contentType(MediaType.APPLICATION_JSON_VALUE).accept(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8").content(this.mapper.writeValueAsBytes(property));

        mockMvc.perform(builder).andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(this.mapper.writeValueAsString(sizeOfEachRoomDTOList)));
    }
}
