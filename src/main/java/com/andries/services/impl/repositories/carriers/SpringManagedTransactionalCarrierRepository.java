package com.andries.services.impl.repositories.carriers;

import com.andries.services.api.repositories.carriers.CarrierRepository;
import com.andries.services.api.resources.carriers.Carrier;
import com.andries.services.impl.qualifiers.RepositoryQualifier;
import com.andries.services.impl.qualifiers.RepositoryType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Andries on 8/18/16.
 */
@RepositoryQualifier(value = RepositoryType.SPRING_MANAGED_TRANSACTIONAL)
@Transactional
@Repository
@Service
public class SpringManagedTransactionalCarrierRepository implements CarrierRepository {

    private static final Logger logger = LoggerFactory.getLogger(SpringManagedTransactionalCarrierRepository.class);

    @PersistenceContext(unitName="CMS")
    private EntityManager em;

    @Override
    public Carrier save(Carrier carrier) {

        logger.info("INVOKING save(..) with Carrier: {}", carrier);

        return  em.merge(carrier);

    }

    @Override
    public List<Carrier> findAll() {

        logger.info("INVOKING findAll()..");

        TypedQuery<Carrier> query = em
                .createNamedQuery("Carrier.findAll", Carrier.class);

        List<Carrier> result = query.getResultList();

        logger.info("FOUND Carriers() {}", result);

        return result;
    }

    @Override
    public Carrier getOne(Long id) {

        logger.info("INVOKING getCarrier(..) with ID: {}", id);

        Carrier carrier = em
                .find(Carrier.class, id);

        return carrier;

    }

}
