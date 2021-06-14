package com.example.MELI.BootCamp.desafioQuality.integration;

import com.example.MELI.BootCamp.desafioQuality.model.Property;
import com.example.MELI.BootCamp.desafioQuality.model.Room;
import com.example.MELI.BootCamp.desafioQuality.repository.APIrepository;
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
public class PropertyControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private APIrepository apIrepository;

    private Property property;
    private Property wrongProperty;

    @BeforeEach
    void setup() {
        propertyConfiguration();
        wrongPropertyConfiguration();
    }

    private void propertyConfiguration() {
        List<Room> roomList = new LinkedList<>();

        roomList.add(new Room("Cozinha",10.0,5.0));
        roomList.add(new Room("Quarto",5.0,5.0));
        roomList.add(new Room("Sala",20.0,10.0));

        property = new Property("TestePropriedade","marambaia",roomList);
    }

    public void wrongPropertyConfiguration() {
        List<Room> roomList = new LinkedList<>();

        roomList.add(new Room("Cozinha",10.0,5.0));
        roomList.add(new Room("Quarto",5.0,5.0));
        roomList.add(new Room("Sala",20.0,10.0));

        wrongProperty = new Property("TestePropriedade","baia",roomList);
    }

    @Test
    public void shouldReturnPropertyArea() throws Exception {
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/property/calculateArea")
                .contentType(MediaType.APPLICATION_JSON_VALUE).accept(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8").content(this.mapper.writeValueAsBytes(property));

        mockMvc.perform(builder).andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("275.0"));
    }

    @Test
    public void shouldReturnPropertyValue() throws Exception {
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/property/calculateValue")
                .contentType(MediaType.APPLICATION_JSON_VALUE).accept(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8").content(this.mapper.writeValueAsBytes(property));

        mockMvc.perform(builder).andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("2750.0"));
    }

    @Test
    public void shouldReturnBadRequestForPropertyValue() throws Exception{
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/property/calculateValue")
                .contentType(MediaType.APPLICATION_JSON_VALUE).accept(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8").content(this.mapper.writeValueAsBytes(wrongProperty));

        mockMvc.perform(builder).andExpect(MockMvcResultMatchers.status().isNotFound());
    }
}
