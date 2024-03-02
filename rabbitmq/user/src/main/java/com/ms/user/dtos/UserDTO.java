package com.ms.user.dtos;

import com.ms.user.entities.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserDTO(@NotBlank @NotNull String username,
                      @NotBlank @Email String email) {
}
