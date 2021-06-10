package com.example.MELI.BootCamp.desafioQuality.controller;

import com.example.MELI.BootCamp.desafioQuality.model.Property;
import com.example.MELI.BootCamp.desafioQuality.service.PropertyCalculatorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/property")
public class PropertyCalculatorController {
    private final PropertyCalculatorService propertyCalculatorService;

    public PropertyCalculatorController(PropertyCalculatorService propertyCalculatorService) {
        this.propertyCalculatorService = propertyCalculatorService;
    }

    @PostMapping("/calculateArea")
    public ResponseEntity<Double> calculatePropertyArea(@RequestBody Property property) {
        return new ResponseEntity<>(propertyCalculatorService.calculatePropertyArea(property), HttpStatus.OK);
    }

    @PostMapping("calculateValue")
    public ResponseEntity<Double> calculatePopertyValue(@RequestBody Property property) {
        return new ResponseEntity<>(propertyCalculatorService.calculatePropertyValue(property),HttpStatus.OK);
    }
}
