package com.dxc.qdang.ecommercedemo.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AdminProductDto {

    @NotBlank(message = "Required")
    private String name;

    private String[] description;

    @NotBlank(message = "Required")
    private String thumbnailUrl;

    @NotBlank(message = "Required")
    @Pattern(regexp = "^\\d*$", message = "Must be a valid non-negative integer")
    private String price;

    private String brand;
    private String category;

}
