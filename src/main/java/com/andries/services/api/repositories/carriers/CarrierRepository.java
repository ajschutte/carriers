package com.andries.services.api.repositories.carriers;

import com.andries.services.api.resources.carriers.Carrier;

import java.util.List;

/**
 * Created by Andries on 8/18/16.
 */
public interface CarrierRepository {

    List<Carrier> findAll();

    Carrier getOne(Long id);

    Carrier save(Carrier carrier);

}
