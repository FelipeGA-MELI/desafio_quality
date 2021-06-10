package com.example.MELI.BootCamp.desafioQuality.service;

import com.example.MELI.BootCamp.desafioQuality.exceptions.DistrictNotFound;
import com.example.MELI.BootCamp.desafioQuality.model.Property;
import com.example.MELI.BootCamp.desafioQuality.model.Room;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        Map<String,Double> districtMap = new HashMap<>();
        Double propertyValue;

        districtMap.put("marambaia",10.0);
        districtMap.put("marco",50.0);
        districtMap.put("jurunas",5.0);
        districtMap.put("guamá",7.0);

        double SquereMeterValue = districtMap.getOrDefault(property.getProp_district(),-1.0);

        if(SquereMeterValue < 0)
            throw new DistrictNotFound("Bairro não encontrado.");

        propertyValue = calculatePropertyArea(property) * SquereMeterValue;

        return propertyValue;
    }
}
