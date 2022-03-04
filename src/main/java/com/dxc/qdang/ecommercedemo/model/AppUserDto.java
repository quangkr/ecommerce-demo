package com.dxc.qdang.ecommercedemo.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AppUserDto {

    @NotBlank(message = "Email must not be blank")
    @Email(
            // https://www.baeldung.com/java-email-validation-regex
            regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$",
            message = "Please provide a valid email address")
    private String email;

    @NotBlank(message = "Password must not be blank")
    @Size(
            min = 8,
            max = 50,
            message = "Password must be between 8 and 50 characters")
    @Pattern(
            // https://stackoverflow.com/questions/22937618/reference-what-does-this-regex-mean/22944075
            regexp = "^(?=.*[0-9])(?=.*[a-zA-Z])(?=\\S+$).*$",
            message = "Password must not contain space, and contain at least an alphabetic and a numeric character")
    private String password;

    @NotBlank(message = "Display name must not be blank")
    @Size(
            max = 50,
            message = "Maximum length of display name must not exceed 50")
    private String displayName;

}
