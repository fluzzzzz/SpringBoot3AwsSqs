package com.springboot3awssqs.repository;

import com.springboot3awssqs.entiity.RecipientEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface RecipientRepository extends R2dbcRepository<RecipientEntity, String> {

}
