package com.tweteroo.api.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/health")
public class HealthController {
  @GetMapping
  public ResponseEntity<String> getHealth() {
    return ResponseEntity.status(HttpStatus.OK).body("I´m OK!!!");
  }
}