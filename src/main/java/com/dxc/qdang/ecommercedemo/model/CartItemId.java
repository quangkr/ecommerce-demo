package com.dxc.qdang.ecommercedemo.model;

import java.io.Serializable;
import java.util.Objects;

import com.dxc.qdang.ecommercedemo.util.SerializableVersion;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CartItemId implements Serializable {

    private static final long serialVersionUID = SerializableVersion.SERIAL_VERSION_UID;

    private CartDetail cartDetail;
    private Product product;

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        CartItemId cartItemId = (CartItemId) o;
        return cartDetail.equals(cartItemId.cartDetail) && product.equals(cartItemId.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cartDetail, product);
    }

}
