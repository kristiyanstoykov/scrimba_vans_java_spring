package com.vans.vans.controller;

import org.springframework.web.bind.annotation.RestController;

import com.vans.vans.dto.VanDto;
import com.vans.vans.model.Van;
import com.vans.vans.service.VanService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/vans")
public class VanController {

    private VanService vanService;

    public VanController(VanService vanService) {
        this.vanService = vanService;
    }

    @GetMapping
    public List<VanDto> getVans() {
        return vanService.getVans();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Van>> getVanById(@PathVariable Long id) {
        Optional<Van> van = vanService.getVanById(id);
        if (van != null) {
            return ResponseEntity.ok(van); // 200 OK
        } else {
            return ResponseEntity.status(404).body(null); // 404 Not Found
        }
    }

    @GetMapping("/host/{hostId}")
    public List<Van> getVansByHost(@PathVariable Long hostId) {
        return vanService.getVansByHostId(hostId);
    }

    @GetMapping("/host_{hostId}")
    public List<Van> getVansByHostId(@PathVariable Long hostId) {
        return vanService.getVansByHostId(hostId);
    }

    @PostMapping
    public VanDto createVan(@RequestBody VanDto vanDto) {
        return vanService.createVan(vanDto);
    }

    // @PutMapping("/{id}")
    // public ResponseEntity<Van> updateVan(@PathVariable Long id, @RequestBody Van
    // vanDetails) {
    // Van updatedVan = vanService.updateVan(id, vanDetails);
    // if (updatedVan != null) {
    // return ResponseEntity.ok(updatedVan); // 200 OK
    // } else {
    // return ResponseEntity.status(404).body(null); // 404 Not Found
    // }
    // }

}
