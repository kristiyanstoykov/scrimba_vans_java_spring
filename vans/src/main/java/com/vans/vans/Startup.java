package com.vans.vans;

import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.vans.vans.dto.RoleDto;
import com.vans.vans.dto.UserDto;
import com.vans.vans.dto.VanDto;
import com.vans.vans.service.RoleService;
import com.vans.vans.service.UserService;
import com.vans.vans.service.VanService;

@Component
@RequiredArgsConstructor
public class Startup implements CommandLineRunner {

    private final RoleService roleService;
    private final UserService userService;
    private final VanService vanService;

    @Override
    public void run(String... args) {
        createDummyData();
    }

    private void createDummyData() {
        if (roleService.getRoles().isEmpty() && userService.getUsers().isEmpty()) {
            RoleDto adminRole = new RoleDto();
            adminRole.setName("ADMIN");
            adminRole = roleService.createRole(adminRole);

            RoleDto userRole = new RoleDto();
            userRole.setName("USER");
            userRole = roleService.createRole(userRole);

            RoleDto modRole = new RoleDto();
            modRole.setName("MODERATOR");
            modRole = roleService.createRole(modRole);

            UserDto admin = new UserDto();
            admin.setName("Admin Adminov");
            admin.setUsername("admin");
            admin.setPassword("pass");
            admin.setEnabled(true);
            admin.setRoles(Set.of(adminRole, modRole));
            userService.createUser(admin);

            UserDto user = new UserDto();
            user.setName("User Userov");
            user.setUsername("user");
            user.setPassword("pass");
            user.setEnabled(true);
            user.setRoles(Set.of(userRole));
            userService.createUser(user);

            UserDto user2 = new UserDto();
            user2.setName("user2");
            user2.setUsername("user2");
            user2.setPassword("pass");
            user2.setRoles(Set.of(userRole));
            userService.createUser(user2);

            UserDto mod = new UserDto();
            mod.setName("mod");
            mod.setUsername("mod");
            mod.setPassword("pass");
            mod.setEnabled(true);
            mod.setRoles(Set.of(modRole));
            userService.createUser(mod);
        }

        if (vanService.getVans().isEmpty()) {
            VanDto van1 = new VanDto();
            van1.setName("Modest Explorer");
            van1.setDescription(
                    "The Modest Explorer is a van designed to get you out of the house and into nature. This beauty is equipped with solar panels, a composting toilet, a water tank and kitchenette. The idea is that you can pack up your home and escape for a weekend or even longer!");
            van1.setPrice(60.00);
            van1.setImageUrl("/assets/images/vans/modest-explorer.png");
            van1.setHostId(1L);
            van1.setType("simple");
            vanService.createVan(van1);

            VanDto van2 = new VanDto();
            van2.setName("Beach Bum");
            van2.setDescription(
                    "Beach Bum is a van inspired by surfers and travelers. It was created to be a portable home away from home, but with some cool features in it you won't find in an ordinary camper.");
            van2.setPrice(80.00);
            van2.setHostId(1L);
            van2.setImageUrl("/assets/images/vans/beach-bum.png");
            van2.setType("rugged");
            vanService.createVan(van2);
        }

    }
}