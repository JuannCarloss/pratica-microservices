package com.ms.user.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AuthenticationDTO(@NotBlank @NotNull String username,
                                @NotBlank @NotNull String password) {
}
