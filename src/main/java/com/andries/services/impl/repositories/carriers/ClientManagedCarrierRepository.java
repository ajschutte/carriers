package com.andries.services.impl.repositories.carriers;

import com.andries.services.api.repositories.carriers.CarrierRepository;
import com.andries.services.api.resources.carriers.Carrier;
import com.andries.services.exceptions.ResourceCreateOrUpdateFailedException;
import com.andries.services.impl.qualifiers.RepositoryQualifier;
import com.andries.services.impl.qualifiers.RepositoryType;
import com.andries.util.MGRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Andries on 11/10/16.
 */
@RepositoryQualifier(value = RepositoryType.MG_REQUEST_TRANSACTIONAL)
@Service
public class ClientManagedCarrierRepository implements CarrierRepository {

    private static final Logger logger = LoggerFactory.getLogger(ClientManagedCarrierRepository.class);

    @Override
    public Carrier save(Carrier carrier) {

        logger.info("INVOKING save(..) with Carrier: {}", carrier);

        MGRequest mgr = null;

        try {
            mgr = new MGRequest();
            return saveCarrier(mgr.getEntityManager(), carrier);
        }
        catch (Throwable th) {

            logger.error("ERROR invoking save(..) with Carrier..", th);

            throw new ResourceCreateOrUpdateFailedException("Carrier could not be saved..." + carrier, th);
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
    public List<Carrier> findAll() {

        MGRequest mgr  = new MGRequest();
        EntityManager em = mgr.getEntityManager();

        try {
            em.getTransaction().begin();
            TypedQuery<Carrier> query = em
                    .createNamedQuery("Carrier.findAll", Carrier.class);
            List<Carrier> result = query.getResultList();
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
    public Carrier getOne(Long id) {
        return null;
    }

    private Long nextId(EntityManager em) throws Exception {

        try {
            em.getTransaction().begin();
            Long nextId = ((BigDecimal)em.createNativeQuery("select CARRIER_SEQ.NEXTVAL from DUAL")
                    .getSingleResult()).longValue();
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
            Long nextId = ((BigDecimal)em.createNativeQuery("select CARRIER_SEQ.CURRVAL from DUAL")
                    .getSingleResult()).longValue();
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

    private Carrier saveCarrier(EntityManager em, Carrier carrier) {

        try {
            em.getTransaction().begin();
            Carrier saved = em.merge(carrier);
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
