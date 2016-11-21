package com.andries.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by Andries on 11/7/16.
 */
public class MGRequest {

    private static final Logger logger = LoggerFactory.getLogger(MGRequest.class);

    private static EntityManagerFactory _factory;
    private EntityManager _entityManager;

    public static synchronized EntityManagerFactory getFactory() {
        if (null == _factory) {
                _factory = Persistence.createEntityManagerFactory("CMS");
        }
        return _factory;
    }

    public EntityManager getEntityManager() {
        if (null == _entityManager) {
            _entityManager = getFactory().createEntityManager();
        }
        return _entityManager;
    }

    public void close() {
        if (_entityManager != null && _entityManager.isOpen()) {

            logger.info("Closing MGRequest....");

            _entityManager.clear();
            _entityManager.close();
        }
    }

}
