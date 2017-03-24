package com.andries.services.impl.repositories.carriers;

import com.andries.services.api.repositories.carriers.DriverRepository;
import com.andries.services.api.resources.carriers.Driver;
import com.andries.services.impl.qualifiers.RepositoryQualifier;
import com.andries.services.impl.qualifiers.RepositoryType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author Andries on 3/24/17.
 */
@RepositoryQualifier(value = RepositoryType.SPRING_MANAGED_TRANSACTIONAL)
@Transactional(propagation = Propagation.REQUIRES_NEW)
@Repository
@Service
public class SpringManagedTransactionalDriverRepository implements DriverRepository {

    private static final Logger logger = LoggerFactory.getLogger(SpringManagedTransactionalDriverRepository.class);

    @PersistenceContext(unitName="CMS")
    private EntityManager em;

    @Override
    public Driver save(Driver driver) {

        logger.info("INVOKING save(..) with Driver: {}", driver);

        return  em.merge(driver);

    }

    @Override
    public List<Driver> findAll() {

        logger.info("INVOKING findAll()..");

        TypedQuery<Driver> query = em
                .createNamedQuery("Driver.findAll", Driver.class);

        List<Driver> result = query.getResultList();

        logger.info("FOUND Drivers() {}", result);

        return result;
    }

    @Override
    public Driver getOne(Long id) {

        logger.info("INVOKING getDriver(..) with ID: {}", id);

        Driver driver = em
                .find(Driver.class, id);

        return driver;

    }

    @Override
    public Long nextId() {

        logger.info("INVOKING nextId()..");

        return ((BigDecimal)em.createNativeQuery("select CARRIER_SEQ.NEXTVAL from DUAL")
                .getSingleResult()).longValue();

    }

    @Override
    public Long currentId() {

        logger.info("INVOKING currentId()..");

        return ((BigDecimal)em.createNativeQuery("select CARRIER_SEQ.CURRVAL from DUAL")
                .getSingleResult()).longValue();

    }

}
