package com.mkruchok.controller;

import com.mkruchok.dto.DeviceDto;
import com.mkruchok.entity.Device;
import com.mkruchok.entity.User;
import com.mkruchok.mapper.AbstractMapper;
import com.mkruchok.mapper.DeviceMapper;
import com.mkruchok.repository.UserRepository;
import com.mkruchok.service.AbstractService;
import com.mkruchok.service.DeviceService;
import com.mkruchok.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("")
@AllArgsConstructor
@Controller
public class AppController {
  private final UserService userService;

  @GetMapping("")
  public String viewHomePage() {
    return "index";
  }

  @GetMapping("/register")
  public String showRegistrationForm(Model model) {
    model.addAttribute("user", new User());

    return "signup_form";
  }

  @PostMapping("/process_register")
  public String processRegister(User user) {
    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    String encodedPassword = passwordEncoder.encode(user.getPassword());
    user.setPassword(encodedPassword);
    user.setName("NULL");

    userService.create(user);

    return "register_success";
  }

}
