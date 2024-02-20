package com.springboot3awssqs.mapper;

import com.springboot3awssqs.dto.NotificationDto;
import com.springboot3awssqs.entiity.NotificationEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NotificationMapper {

    NotificationDto map(NotificationEntity entity);

    @InheritInverseConfiguration
    NotificationEntity map(NotificationDto dto);

}