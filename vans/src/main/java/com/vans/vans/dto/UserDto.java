package com.vans.vans.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;

import java.util.List;
import java.util.Set;

import com.vans.vans.validation.CreateValidationGroup;
import com.vans.vans.validation.UpdateValidationGroup;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {

    @Null(groups = { CreateValidationGroup.class })
    @NotNull(groups = { UpdateValidationGroup.class })
    private Long id;

    private String name;
    private String username;
    private String email;

    @NotNull(groups = { CreateValidationGroup.class })
    @Null(groups = { UpdateValidationGroup.class })
    private String password;

    private Set<RoleDto> roles;
    private List<VanDto> vans;

    private boolean isEnabled;
}