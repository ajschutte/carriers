package com.andries.services.impl.qualifiers;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by Andries on 11/9/16.
 */
@Retention(RetentionPolicy.RUNTIME)
@Qualifier
public @interface RepositoryQualifier {

    RepositoryType value();

}
