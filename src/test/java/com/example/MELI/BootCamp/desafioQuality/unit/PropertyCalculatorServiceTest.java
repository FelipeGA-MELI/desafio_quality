package com.example.MELI.BootCamp.desafioQuality.unit;

import com.example.MELI.BootCamp.desafioQuality.model.Property;
import com.example.MELI.BootCamp.desafioQuality.model.Room;
import com.example.MELI.BootCamp.desafioQuality.repository.APIrepository;
import com.example.MELI.BootCamp.desafioQuality.service.PropertyCalculatorService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import java.util.LinkedList;
import java.util.List;

@SpringBootTest
public class PropertyCalculatorServiceTest {
    @MockBean
    private APIrepository apIrepository;

    @Autowired
    private PropertyCalculatorService propertyCalculatorService;

    private Property property;

    @BeforeEach
    void setup() {
        configureProperty();
        Mockito.when(apIrepository.getValueByDistrict("marambaia")).thenReturn(10.0);
    }

    private void configureProperty() {
        List<Room> roomList = new LinkedList<>();

        roomList.add(new Room("Cozinha",10.0,5.0));
        roomList.add(new Room("Quarto",5.0,5.0));
        roomList.add(new Room("Sala",20.0,10.0));

        property = new Property("TestePropriedade","marambaia",roomList);
    }

    @Test
    public void shouldReturnRightPropertyArea() {
        Double propertyArea = propertyCalculatorService.calculatePropertyArea(property);

        Assertions.assertEquals(275,propertyArea);
    }

    @Test
    public void shouldReturnPropertyValue() {
        Double propertyValue = propertyCalculatorService.calculatePropertyValue(property);

        Assertions.assertEquals(2750,propertyValue);
    }
}
