package com.vans.vans.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;

import com.vans.vans.dto.RoleDto;
import com.vans.vans.service.RoleService;

@RestController
@RequestMapping("/role")
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping
    public List<RoleDto> getRoles() {
        return roleService.getRoles();
    }

    @PostMapping
    public RoleDto createRole(@RequestBody RoleDto userDto) {
        return roleService.createRole(userDto);
    }
}