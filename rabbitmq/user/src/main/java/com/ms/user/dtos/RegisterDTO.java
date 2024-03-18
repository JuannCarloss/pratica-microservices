package com.ms.user.dtos;

import com.ms.user.enums.UserRoles;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RegisterDTO(@NotNull @NotBlank String username,
                          @NotNull @NotBlank String email,
                          @NotNull @NotBlank String password,
                          @NotNull UserRoles role) {
}
