package com.tweteroo.api.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class TweetDTO{
    @NotNull(message = "UserId provided is null")
    private Long userId;
    
    @NotBlank(message = "Tweet must not be blank")
    @Size(max = 200, message = "Tweet must have a maximum of one hundred characters")
    private String text;
}
