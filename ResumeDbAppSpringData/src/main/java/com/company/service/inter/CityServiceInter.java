package com.company.service.inter;

import com.company.model.City;

import java.util.List;
import java.util.Optional;

public interface CityServiceInter {
    List<City> getAll();
   Optional<City> getById(Integer id);
    City addCity(City city);
    City updateCity(City city);
    void deleteCity(Integer id);
}
