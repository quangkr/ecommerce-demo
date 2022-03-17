package com.dxc.qdang.ecommercedemo.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import com.dxc.qdang.ecommercedemo.util.SerializableVersion;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Embeddable
public class OrderItemId implements Serializable {

    private static final long serialVersionUID = SerializableVersion.SERIAL_VERSION_UID;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private OrderDetail orderDetail;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    private Product product;

}
