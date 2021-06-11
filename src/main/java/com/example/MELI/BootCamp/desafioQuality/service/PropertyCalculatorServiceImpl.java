package com.example.MELI.BootCamp.desafioQuality.service;

import com.example.MELI.BootCamp.desafioQuality.model.Property;
import com.example.MELI.BootCamp.desafioQuality.model.Room;
import com.example.MELI.BootCamp.desafioQuality.repository.APIrepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PropertyCalculatorServiceImpl implements PropertyCalculatorService {
    private final APIrepository apIrepository;

    public PropertyCalculatorServiceImpl(APIrepository apIrepository) {
        this.apIrepository = apIrepository;
    }

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
        Double districtValue = apIrepository.getValueByDistrict(property.getProp_district());

        Double propertyValue = districtValue * calculatePropertyArea(property);

        return propertyValue;
    }
}
