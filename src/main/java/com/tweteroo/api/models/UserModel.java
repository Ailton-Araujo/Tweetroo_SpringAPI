package com.tweteroo.api.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import com.tweteroo.api.dtos.UserDTO;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
  
    @Column(nullable = false)
    private String avatar;
  
    @Column(nullable = false, length = 100)
    private String userName;
  
    public UserModel(UserDTO dto) {
      this.avatar = dto.getAvatar();
      this.userName = dto.getUserName();
    }

}