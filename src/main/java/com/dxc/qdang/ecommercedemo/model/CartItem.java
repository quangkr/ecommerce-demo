package com.dxc.qdang.ecommercedemo.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class CartItem implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    CartItemId id;

    private int quantity;

}
