package com.example.MELI.BootCamp.desafioQuality.model;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

public class Property {
    @NotNull(message = "O nome da propriedade não pode estar vazio.")
    @Size(min = 1, max = 30, message = "O comprimento do nome não pode exceder 30 caracteres.")
    @Pattern(regexp = "^[A-Z][a-zA-Z]+$", message = "O nome da propriedade deve começar com uma letra maiúscula.")
    private String prop_name;

    @NotNull(message = "O bairro não pode estar vazio.")
    @Size(min = 1,max = 40,message = "Comprimento máximo de 45 caracteres.")
    private String prop_district;

    @Valid
    private List<Room> prop_rooms;

    public Property() { }

    public Property(String prop_name, String prop_district, List<Room> prop_rooms) {
        this.prop_name = prop_name;
        this.prop_district = prop_district;
        this.prop_rooms = prop_rooms;
    }

    public String getProp_name() {
        return prop_name;
    }

    public void setProp_name(String prop_name) {
        this.prop_name = prop_name;
    }

    public String getProp_district() {
        return prop_district;
    }

    public void setProp_district(String prop_district) {
        this.prop_district = prop_district;
    }

    public List<Room> getProp_rooms() {
        return prop_rooms;
    }

    public void setProp_rooms(List<Room> prop_rooms) {
        this.prop_rooms = prop_rooms;
    }
}
