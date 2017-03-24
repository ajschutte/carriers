package com.andries.services.api.repositories.carriers;

import com.andries.services.api.resources.carriers.Driver;

import java.util.List;

/**
 * @author Andries on 3/24/17.
 */
public interface DriverRepository {

    List<Driver> findAll();

    Driver getOne(Long id);

    Driver save(Driver driver);

    Long nextId();

    Long currentId();

}
