package com.company.service.impl;

import com.company.model.City;
import com.company.model.University;
import com.company.repository.CityRepository;
import com.company.service.inter.CityServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@Service
public class CityServiceImpl implements CityServiceInter {

    private CityRepository cityRepository;

    @Autowired
    public CityServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public List<City> getAll() {
        List<City> city = cityRepository.findAll();
        return city;
    }

    @Override
    public Optional<City> getById(Integer id) {
        Optional<City> city = cityRepository.findById(id);
        return city;
    }

    @Override
    public City addCity(City city) {
        cityRepository.save(city);
        return city;
    }

    @Override
    public City updateCity(City city) {
        Optional<City> findCity = cityRepository.findById(city.getId());
        City updateCity = null;
        if(findCity.isPresent()) {
            updateCity = findCity.get();
            updateCity.setCityName(city.getCityName());
            cityRepository.save(updateCity);
        }
        return updateCity;
    }

    @Override
    public void deleteCity(Integer id) {
        cityRepository.deleteById(id);
    }
}
