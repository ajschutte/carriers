package com.andries.services.api.controllers.carriers;

import com.andries.services.api.repositories.carriers.CarrierRepository;
import com.andries.services.api.resources.carriers.Carrier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Andries on 8/9/16.
 */
@RestController
public class CarrierController {

    private static final Logger logger = LoggerFactory.getLogger(CarrierController.class);

    @Autowired
    private CarrierRepository repository;

    @RequestMapping(value = "/carrier/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Carrier getCarrier(@PathVariable(value="name") String name) {

        try {
            logger.info("INVOKING getCarrier(..)..Carrier Passed: {}..", name);

            Carrier carrier = repository.saveCarrier(new Carrier(name));

            for (Carrier savedCarrier : repository.listAllCarriers()) {
                logger.info("Carrier found: {}..", savedCarrier);
            }

            return carrier;
        }
        catch (Exception exx) {
            logger.error("ERROR getCarrier(..)..", exx);
            throw exx;
        }
    }

}
