package com.vans.vans.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vans.vans.model.Van;

@Repository
public interface VanRepository extends JpaRepository<Van, Long> {
    List<Van> findVansByHostId(Long hostId);
}
