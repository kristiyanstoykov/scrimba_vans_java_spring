package com.vans.vans.mapper;

import org.mapstruct.*;

import com.vans.vans.dto.UserDto;
import com.vans.vans.model.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toDto(User entity);

    User toEntity(UserDto entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updatePartial(@MappingTarget User entity, UserDto dto);
}