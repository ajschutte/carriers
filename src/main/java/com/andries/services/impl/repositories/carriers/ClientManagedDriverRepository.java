package com.andries.services.impl.repositories.carriers;

import com.andries.services.api.repositories.carriers.DriverRepository;
import com.andries.services.api.resources.carriers.Driver;
import com.andries.services.exceptions.ResourceCreateOrUpdateFailedException;
import com.andries.services.impl.qualifiers.RepositoryQualifier;
import com.andries.services.impl.qualifiers.RepositoryType;
import com.andries.util.MGRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * @author Andries on 3/24/17.
 */
@RepositoryQualifier(value = RepositoryType.MG_REQUEST_TRANSACTIONAL)
@Service
public class ClientManagedDriverRepository implements DriverRepository {

    private static final Logger logger = LoggerFactory.getLogger(ClientManagedDriverRepository.class);

    @Override
    public Driver save(Driver driver) {

        logger.info("INVOKING save(..) with Driver: {}", driver);

        MGRequest mgr = null;

        try {
            mgr = new MGRequest();
            return saveDriver(mgr.getEntityManager(), driver);
        }
        catch (Throwable th) {

            logger.error("ERROR invoking save(..) with Driver..", th);

            throw new ResourceCreateOrUpdateFailedException("Driver could not be saved..." + driver, th);
        }
        finally {
            if (mgr != null) {
                mgr.close();
            }
        }

    }

    @Override
    public Long nextId() {

        logger.info("INVOKING nextId()..");

        MGRequest mgr = null;

        try {
            mgr = new MGRequest();
            return nextId(mgr.getEntityManager());
        }
        catch (Throwable th) {

            logger.error("ERROR invoking nextId(..)..", th);

            throw new ResourceCreateOrUpdateFailedException("Error in nextId()...", th);
        }
        finally {
            if (mgr != null) {
                mgr.close();
            }
        }

    }

    @Override
    public Long currentId() {

        logger.info("INVOKING currentId()..");

        MGRequest mgr = null;

        try {
            mgr = new MGRequest();
            return nextId(mgr.getEntityManager());
        }
        catch (Throwable th) {

            logger.error("ERROR invoking currentId(..)..", th);

            throw new ResourceCreateOrUpdateFailedException("Error in currenttId()...", th);
        }
        finally {
            if (mgr != null) {
                mgr.close();
            }
        }

    }

    @Override
    public List<Driver> findAll() {

        MGRequest mgr  = new MGRequest();
        EntityManager em = mgr.getEntityManager();

        try {
            em.getTransaction().begin();
            TypedQuery<Driver> query = em
                    .createNamedQuery("Driver.findAll", Driver.class);
            List<Driver> result = query.getResultList();
            em.getTransaction().commit();
            return result;
        }
        catch (Throwable th) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw th;
        }
        finally {
            if (mgr != null) mgr.close();
        }

    }

    @Override
    public Driver getOne(Long id) {
        return null;
    }

    private Long nextId(EntityManager em) throws Exception {

        try {
            em.getTransaction().begin();
            Long nextId = (Long)em.createNativeQuery("select DRIVER_SEQ.NEXTVAL from DUAL").getSingleResult();
            em.getTransaction().commit();
            return nextId;
        }
        catch (Throwable th) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw th;
        }

    }

    private Long currentId(EntityManager em) throws Exception {

        try {
            em.getTransaction().begin();
            Long nextId = (Long)em.createNativeQuery("select DRIVER_SEQ.CURRENTVAL from DUAL").getSingleResult();
            em.getTransaction().commit();
            return nextId;
        }
        catch (Throwable th) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw th;
        }

    }

    private Driver saveDriver(EntityManager em, Driver driver) {

        try {
            em.getTransaction().begin();
            Driver saved = em.merge(driver);
            em.getTransaction().commit();
            return saved;
        }
        catch (Throwable th) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw th;
        }

    }

}
