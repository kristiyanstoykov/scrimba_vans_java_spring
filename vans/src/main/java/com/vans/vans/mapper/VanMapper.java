package com.vans.vans.mapper;

import org.mapstruct.*;

import com.vans.vans.dto.VanDto;
import com.vans.vans.model.Van;

@Mapper(componentModel = "spring")
public interface VanMapper {

    VanDto toDto(Van entity);

    Van toEntity(VanDto entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updatePartial(@MappingTarget Van entity, VanDto dto);
}