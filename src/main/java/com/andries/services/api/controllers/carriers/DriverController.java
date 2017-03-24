package com.andries.services.api.controllers.carriers;

import com.andries.services.api.repositories.carriers.DriverRepository;
import com.andries.services.api.resources.carriers.Driver;
import com.andries.services.impl.qualifiers.RepositoryQualifier;
import com.andries.services.impl.qualifiers.RepositoryType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Andries on 3/24/17.
 */
@RestController
public class DriverController {

    private static final Logger logger = LoggerFactory.getLogger(DriverController.class);

    /**
     * Modify the value of the qualifier to pick which implementation gets used...
     */
    @RepositoryQualifier(value = RepositoryType.SPRING_MANAGED_TRANSACTIONAL)
    @Autowired
    private DriverRepository repository;

    /**
     * This silly implementation creates a new Carrier, then returns a list of all current Carriers...
     *
     * @param name Carrier Name
     * @return Carrier
     */
    @RequestMapping(value = "/driver/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Driver getDriver(@PathVariable(value="name") String name) {

        try {
            logger.info("INVOKING getDriver(..)..Driver Passed: {}..", name);

            Driver driver = repository.save(new Driver(name));

            for (Driver savedDriver : repository.findAll()) {
                logger.info("Driver found: {}..", savedDriver);
            }

            return driver;
        }
        catch (Exception exx) {
            logger.error("ERROR getDriver(..)..", exx);
            throw exx;
        }
    }

    @RequestMapping(value = "/driver-id/currentval", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Long getDriverIdCurrentVal() {

        try {
            logger.info("INVOKING getDriverIdCurrentVal(..)..");

            return repository.currentId();
        }
        catch (Exception exx) {
            logger.error("ERROR getDriverIdCurrentVal(..)..", exx);
            throw exx;
        }
    }

    @RequestMapping(value = "/driver-id/nextval", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Long getDriverIdNextVal() {

        try {
            logger.info("INVOKING getDriverIdNextVal(..)..");

            return repository.nextId();
        }
        catch (Exception exx) {
            logger.error("ERROR getDriverIdNextVal(..)..", exx);
            throw exx;
        }
    }

}
