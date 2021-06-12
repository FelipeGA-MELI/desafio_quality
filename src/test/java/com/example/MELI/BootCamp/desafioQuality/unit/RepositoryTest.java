package com.example.MELI.BootCamp.desafioQuality.unit;

import com.example.MELI.BootCamp.desafioQuality.exceptions.DistrictNotFound;
import com.example.MELI.BootCamp.desafioQuality.repository.APIrepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RepositoryTest {
    @Autowired
    private APIrepository apIrepository;

    @Test
    public void shouldReturnException() {
        Assertions.assertThrows(DistrictNotFound.class, () -> apIrepository.getValueByDistrict("mara"));
    }

    @Test
    public void shouldReturnValueOfDistrict() {
        Double districtValue = apIrepository.getValueByDistrict("marambaia");

        Assertions.assertEquals(10.0,districtValue);
    }
}
