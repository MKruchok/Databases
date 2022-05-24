package com.mkruchok.service;

import com.mkruchok.entity.User;
import com.mkruchok.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserService extends AbstractService<User, Integer> {
  private UserRepository userRepository;

  @Override
  protected JpaRepository<User, Integer> getRepository() {
    return userRepository;
  }

}