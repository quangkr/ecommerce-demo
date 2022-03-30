package com.dxc.qdang.ecommercedemo.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import com.dxc.qdang.ecommercedemo.util.SerializableVersion;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ShippingDetailDto implements Serializable {

    private static final long serialVersionUID = SerializableVersion.SERIAL_VERSION_UID;

    @NotBlank(message = "Required")
    private String fullName;

    @NotBlank(message = "Required")
    private String phoneNumber;

    @NotBlank(message = "Required")
    private String address;

    @NotBlank(message = "Required")
    private String ward;

    @NotBlank(message = "Required")
    private String district;

    @NotBlank(message = "Required")
    private String city;

}
