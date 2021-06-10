package com.example.MELI.BootCamp.desafioQuality.model;

import java.util.List;

public class Property {
    private String prop_name;
    private String prop_district;
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
