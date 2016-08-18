package com.andries.services.impl.repositories.carriers;

import com.andries.services.api.repositories.carriers.CarrierRepository;
import com.andries.services.api.resources.carriers.Carrier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Andries on 8/18/16.
 */
@Repository
@Transactional
public class DefaultCarrierRepository implements CarrierRepository {

    private static final Logger logger = LoggerFactory.getLogger(DefaultCarrierRepository.class);

    @PersistenceUnit
    private EntityManagerFactory emf;

    @Override
    public List<Carrier> listAllCarriers() {

        logger.info("INVOKING listAllCarriers()..");

        TypedQuery<Carrier> query = emf
                .createEntityManager()
                .createNamedQuery("Carrier.findAll", Carrier.class);
        return query.getResultList();
    }

    @Override
    public Carrier getCarrier(Long id) {

        logger.info("INVOKING getCarrier(..) with ID: {}", id);

        return emf.createEntityManager()
                .find(Carrier.class, id);

    }

    @Override
    public Carrier saveCarrier(Carrier carrier) {

        logger.info("INVOKING saveCarrier(..) with Carrier: {}", carrier);

        return emf.createEntityManager()
                .merge(carrier);

    }
}
