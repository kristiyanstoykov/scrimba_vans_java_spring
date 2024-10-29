package com.vans.vans.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.vans.vans.dto.VanDto;
import com.vans.vans.mapper.VanMapper;
import com.vans.vans.model.Van;
import com.vans.vans.repository.VanRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class VanService {

    private final VanRepository vanRepository;
    private final VanMapper vanMapper;

    public List<VanDto> getVans() {
        return vanRepository.findAll().stream().map(vanMapper::toDto).toList();
    }

    public Optional<Van> getVanById(Long id) {
        return vanRepository.findById(id);
    }

    public List<Van> getVansByHostId(Long hostId) {
        return vanRepository.findVansByHostId(hostId);
    }

    public VanDto createVan(VanDto vanDto) {
        return vanMapper.toDto(vanRepository.save(vanMapper.toEntity(vanDto)));
    }

    public VanDto updateVan(VanDto vanDto) {
        var existing = getVanById(vanDto.getId());
        if (existing.isEmpty()) {
            throw new EntityNotFoundException();
        }
        vanMapper.updatePartial(existing.get(), vanDto);
        return vanMapper.toDto(vanRepository.save(existing.get()));
    }

}
