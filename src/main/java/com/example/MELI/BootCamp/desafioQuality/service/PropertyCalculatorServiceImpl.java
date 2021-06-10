package com.example.MELI.BootCamp.desafioQuality.service;

import com.example.MELI.BootCamp.desafioQuality.model.Property;
import com.example.MELI.BootCamp.desafioQuality.model.Room;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PropertyCalculatorServiceImpl implements PropertyCalculatorService {
    @Override
    public Double calculatePropertyArea(Property property) {
        List<Room> roomList = property.getProp_rooms();
        Double propertyArea = 0.0;

        for(Room room: roomList)
            propertyArea += room.getRoom_length() * room.getRoom_width();

        return propertyArea;
    }

    @Override
    public Double calculatePropertyValue(Property property) {
        return null;
    }
}
