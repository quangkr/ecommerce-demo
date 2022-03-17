package com.dxc.qdang.ecommercedemo.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;

import com.dxc.qdang.ecommercedemo.util.SerializableVersion;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@IdClass(OrderItemId.class)
public class OrderItem implements Serializable {

    private static final long serialVersionUID = SerializableVersion.SERIAL_VERSION_UID;

    @Id
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private OrderDetail orderDetail;

    @Id
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    private Product product;

    private int quantity;

}
