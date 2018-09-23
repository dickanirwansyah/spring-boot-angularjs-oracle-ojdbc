package com.fusi24.springfusi24angularjs.repository;

import com.fusi24.springfusi24angularjs.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Long> {
}
