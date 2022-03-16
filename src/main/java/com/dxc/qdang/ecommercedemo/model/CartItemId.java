package com.dxc.qdang.ecommercedemo.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Embeddable
public class CartItemId implements Serializable {

    private static final long serialVersionUID = 1L;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private CartDetail cartDetail;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    private Product product;

}
