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
import java.util.List;

/**
 * Created by Andries on 11/10/16.
 */
@RepositoryQualifier(value = RepositoryType.MG_REQUEST_TRANSACTIONAL)
@Service
public class ClientManagedCarrierRepository implements CarrierRepository {

    private static final Logger logger = LoggerFactory.getLogger(ClientManagedCarrierRepository.class);

    @Override
    public Carrier saveCarrier(Carrier carrier) {

        logger.info("INVOKING saveCarrier(..) with Carrier: {}", carrier);

        MGRequest mgr = null;

        try {
            mgr = new MGRequest();
            return saveCarrier(mgr.getEntityManager(), carrier);
        }
        catch (Throwable th) {

            logger.error("ERROR invoking saveCarrier(..) with Carrier..", th);

            throw new ResourceCreateOrUpdateFailedException("Carrier could not be saved..."+carrier, th);
        }
        finally {
            if (mgr != null) {
                mgr.close();
            }
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

    @Override
    public List<Carrier> listAllCarriers() {

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
    public Carrier getCarrier(Long id) {
        return null;
    }

}
