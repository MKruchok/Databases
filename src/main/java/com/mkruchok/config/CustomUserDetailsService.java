package com.mkruchok.config;

import com.mkruchok.Application;
import com.mkruchok.entity.Device;
import com.mkruchok.entity.User;
import com.mkruchok.repository.DeviceRepository;
import com.mkruchok.repository.UserRepository;
import com.mkruchok.service.AbstractService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService {

  @Autowired
  private UserRepository userRepo;

  static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userRepo.findByEmail(username);
    if (user == null) {
      LOGGER.error("The email or password is incorrect");
      throw new UsernameNotFoundException("User not found");
    }
    return new CustomUserDetails(user);
  }

}