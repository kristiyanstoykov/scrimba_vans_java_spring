package com.vans.vans.dto;

import com.vans.vans.validation.CreateValidationGroup;
import com.vans.vans.validation.UpdateValidationGroup;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoleDto {

    @Null(groups = { CreateValidationGroup.class })
    @NotNull(groups = { UpdateValidationGroup.class })
    private Long id;
    private String name;
}
