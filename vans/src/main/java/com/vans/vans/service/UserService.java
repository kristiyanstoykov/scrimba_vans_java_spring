package com.vans.vans.service;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.vans.vans.dto.UserDto;
import com.vans.vans.mapper.UserMapper;
import com.vans.vans.model.User;
import com.vans.vans.repository.UserRepository;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {

  private final UserRepository repository;
  private final UserMapper mapper;
  private final PasswordEncoder passwordEncoder;

  public List<UserDto> getUsers() {
    return repository.findAll().stream().map(mapper::toDto).toList();
  }

  public Optional<User> getById(Long id) {
    return repository.findById(id);
  }

  public Optional<User> getByUsername(String username) {
    return repository.findByUsername(username);
  }

  public UserDto createUser(UserDto dto) {
    dto.setPassword(passwordEncoder.encode(dto.getPassword()));
    return mapper.toDto(repository.save(mapper.toEntity(dto)));
  }

  public UserDto updateUser(UserDto dto) {
    var existing = getById(dto.getId());
    if (existing.isEmpty()) {
      throw new EntityNotFoundException();
    }
    mapper.updatePartial(existing.get(), dto);
    return mapper.toDto(repository.save(existing.get()));
  }
}