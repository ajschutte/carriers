package com.andries.services.api.controllers.carriers;

import com.andries.services.api.repositories.carriers.CarrierRepository;
import com.andries.services.api.resources.carriers.Carrier;
import com.andries.services.impl.qualifiers.RepositoryQualifier;
import com.andries.services.impl.qualifiers.RepositoryType;
import com.andries.services.impl.repositories.carriers.SpringGeneratedCarrierRepository;
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

    @RepositoryQualifier(value = RepositoryType.SPRING_MANAGED_TRANSACTIONAL)
    @Autowired
    private CarrierRepository repository;

    @Autowired
    private SpringGeneratedCarrierRepository springRepository;

    @RequestMapping(value = "/carrier/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Carrier getCarrier(@PathVariable(value="name") String name) {

        try {
            logger.info("INVOKING getCarrier(..)..Carrier Passed: {}..", name);

            //Carrier carrier = repository.saveCarrier(new Carrier(name));

            Carrier carrier = springRepository.save(new Carrier(name));

            //for (Carrier savedCarrier : repository.listAllCarriers()) {
            //    logger.info("Carrier found: {}..", savedCarrier);
           // }

            for (Carrier savedCarrier : springRepository.findAll()) {
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
