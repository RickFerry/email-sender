package com.ms.user.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public record UserDto(
        UUID id,
        @NotBlank String name,
        @NotBlank @Email String email
) { }
