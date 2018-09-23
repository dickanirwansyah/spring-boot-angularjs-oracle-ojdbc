package com.fusi24.springfusi24angularjs.controller;

import com.fusi24.springfusi24angularjs.entity.City;
import com.fusi24.springfusi24angularjs.exception.ResourceNotFoundException;
import com.fusi24.springfusi24angularjs.repository.CityRepository;
import com.fusi24.springfusi24angularjs.repository.ProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/city/api")
public class CityController {

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private ProvinceRepository provinceRepository;

    @GetMapping
    public List<City> getList(){
        return cityRepository.findAll();
    }

    @PostMapping(value = "/{provinceId}/create")
    public City create(@PathVariable("provinceId") Long provinceId,
                       @RequestBody City city){

        return provinceRepository.findById(provinceId)
                .map(province -> {
                    city.setProvince(province);
                    return cityRepository.save(city);
                }).orElseThrow(() ->
                        new ResourceNotFoundException("province id : "+provinceId+" notfound"));
    }

    @PutMapping(value = "/{provinceId}/{cityId}")
    public City update(@PathVariable("provinceId") Long provinceId,
                       @PathVariable("cityId") Long cityId,
                       @RequestBody City city){

        return provinceRepository.findById(provinceId)
                .map(province -> {
                    return cityRepository.findById(cityId)
                            .map(currentCity -> {
                                currentCity.setProvince(province);
                                currentCity.setName(city.getName());
                                return cityRepository.save(currentCity);
                            }).orElseThrow(() -> new ResourceNotFoundException("city id : "+cityId+" notfound"));
                }).orElseThrow(() -> new ResourceNotFoundException("province id : "+provinceId+" notfound"));
    }
}
