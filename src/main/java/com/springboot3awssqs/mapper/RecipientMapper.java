package com.springboot3awssqs.mapper;

import com.springboot3awssqs.dto.RecipientDto;
import com.springboot3awssqs.entiity.RecipientEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface RecipientMapper {

    RecipientDto map(RecipientEntity entity);

    @InheritInverseConfiguration
    RecipientEntity map(RecipientDto dto);
}

