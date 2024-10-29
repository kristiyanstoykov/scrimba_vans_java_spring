package com.vans.vans.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;

import com.vans.vans.validation.CreateValidationGroup;
import com.vans.vans.validation.UpdateValidationGroup;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VanDto {

    @Null(groups = { CreateValidationGroup.class })
    @NotNull(groups = { UpdateValidationGroup.class })
    private Long id;

    private String name;
    private Double price;
    private String description;
    private String imageUrl;
    private String type;

    private Long hostId;
}