package com.andries.services.impl.repositories.carriers;

import com.andries.services.api.repositories.carriers.CarrierRepository;
import com.andries.services.api.resources.carriers.Carrier;
import com.andries.services.impl.qualifiers.RepositoryQualifier;
import com.andries.services.impl.qualifiers.RepositoryType;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Andries on 11/11/16.
 */
@RepositoryQualifier(value = RepositoryType.SPRING_MANAGED_GENERATED)
public interface SpringGeneratedCarrierRepository extends JpaRepository<Carrier, Long>, CarrierRepository {

}
