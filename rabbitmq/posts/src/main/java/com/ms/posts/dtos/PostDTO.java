package com.ms.posts.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record PostDTO(@NotBlank @NotNull String username,
                      @NotBlank @NotNull String title,
                      @NotBlank @NotNull String body) {
}
