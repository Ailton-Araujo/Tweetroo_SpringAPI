package com.tweteroo.api.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class UserDTO {
    private static final String URL_PATTERN = "^https?://\\S+$";

    @NotBlank(message = "Avatar must not be blank")
    @Pattern(regexp = URL_PATTERN, message = "Avatar should in the format of a URL")
    private String avatar;

    @NotBlank(message = "Username must not be blank")
    @Size(max = 100, message = "UserName must have a maximum of one hundred characters")
    private String userName;
}