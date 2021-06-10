package com.example.MELI.BootCamp.desafioQuality.service;

import com.example.MELI.BootCamp.desafioQuality.model.Property;

public interface PropertyCalculatorService {
    Double calculatePropertyArea(Property property);

    Double calculatePropertyValue(Property property);
}
