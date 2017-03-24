package com.andries.services.impl.repositories.carriers;

import com.andries.services.api.repositories.carriers.DriverRepository;
import com.andries.services.api.resources.carriers.Driver;
import com.andries.services.impl.qualifiers.RepositoryQualifier;
import com.andries.services.impl.qualifiers.RepositoryType;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Andries on 3/24/17.
 */
@RepositoryQualifier(value = RepositoryType.SPRING_MANAGED_GENERATED)
public interface SpringGeneratedDriverRepository extends JpaRepository<Driver, Long>, DriverRepository {

    @Override
    default Long nextId() {
        return 0L;
    }

    @Override
    default Long currentId() {
        return 0L;
    }

}
