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

    @NotBlank(message = "Recipient name must not be blank")
    private String fullName;

    @NotBlank(message = "Phone number must not be blank")
    private String phoneNumber;

    @NotBlank(message = "Address must not be blank")
    private String address;

    @NotBlank(message = "Ward must not be blank")
    private String ward;

    @NotBlank(message = "District must not be blank")
    private String district;

    @NotBlank(message = "City must not be blank")
    private String city;

}
