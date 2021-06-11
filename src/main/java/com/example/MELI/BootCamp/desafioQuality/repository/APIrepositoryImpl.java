package com.example.MELI.BootCamp.desafioQuality.repository;

import com.example.MELI.BootCamp.desafioQuality.exceptions.DistrictNotFound;
import org.springframework.stereotype.Repository;
import java.util.HashMap;
import java.util.Map;

@Repository
public class APIrepositoryImpl implements APIrepository{
    @Override
    public Double getValueByDistrict(String district) {
        Map<String,Double> districtMap = new HashMap<>();

        districtMap.put("marambaia",10.0);
        districtMap.put("marco",50.0);
        districtMap.put("jurunas",5.0);
        districtMap.put("guamá",7.0);

        double SquereMeterValue = districtMap.getOrDefault(district,-1.0);

        if(SquereMeterValue < 0)
            throw new DistrictNotFound("Bairro não encontrado.");

        return SquereMeterValue;
    }
}
