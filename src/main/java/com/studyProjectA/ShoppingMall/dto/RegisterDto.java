package com.studyProjectA.ShoppingMall.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterDto {
    @NotNull
    private String username;

    @NotNull
    private String password;

    @NotNull
    private String email;
    @NotNull
    private String address;
}
