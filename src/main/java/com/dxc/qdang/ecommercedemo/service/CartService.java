package com.dxc.qdang.ecommercedemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dxc.qdang.ecommercedemo.model.AppUser;
import com.dxc.qdang.ecommercedemo.model.CartDetail;
import com.dxc.qdang.ecommercedemo.model.CartItem;
import com.dxc.qdang.ecommercedemo.model.CartItemId;
import com.dxc.qdang.ecommercedemo.repository.CartRepository;
import com.dxc.qdang.ecommercedemo.repository.ProductRepository;
import com.dxc.qdang.ecommercedemo.security.AppUserDetails;

@Service
@Transactional
public class CartService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CartRepository cartRepository;

    public CartDetail addToCart(AppUserDetails userDetails, Long productId) {
        AppUser user = new AppUser();
        user.setId(userDetails.getUserId());
        CartDetail cart = cartRepository.findByUser(user);

        List<CartItem> items = cart.getCartItems();
        CartItem item = null;
        for (CartItem i : items) {
            if (Long.compare(i.getId().getProduct().getId(), productId) == 0) {
                item = i;

                int quantity = item.getQuantity();
                item.setQuantity(quantity + 1);
                break;
            }
        }

        if (item == null) {
            item = new CartItem();
            item.setId(new CartItemId());
            item.getId().setCartDetail(cart);
            item.getId().setProduct(productRepository.findById(productId).orElse(null));
            item.setQuantity(1);
        }
        items.add(item);

        return cartRepository.save(cart);
    }

}
