package com.dxc.qdang.ecommercedemo.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dxc.qdang.ecommercedemo.model.AppUser;
import com.dxc.qdang.ecommercedemo.model.CartDetail;
import com.dxc.qdang.ecommercedemo.model.CartItem;
import com.dxc.qdang.ecommercedemo.repository.CartRepository;
import com.dxc.qdang.ecommercedemo.repository.ProductRepository;
import com.dxc.qdang.ecommercedemo.security.AppUserDetails;

@Service
@Transactional
public class CartService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CartRepository cartRepository;

    public CartDetail getCart(AppUserDetails userDetails) {
        return getCartByUser(userDetails);
    }

    public CartDetail addProduct(AppUserDetails userDetails, long productId, int quantity) {
        CartDetail cart = getCartByUser(userDetails);
        CartItem item = getOrCreateCartItemByProductId(cart, productId);
        item.setQuantity(item.getQuantity() + quantity);

        return cartRepository.save(cart);
    }

    public CartDetail setProductQuantity(AppUserDetails userDetails, long productId, int quantity) {
        CartDetail cart = getCartByUser(userDetails);

        if (quantity <= 0) {
            Iterator<CartItem> iter = cart.getCartItems().iterator();
            while (iter.hasNext()) {
                if (iter.next().getProduct().getId() == productId) {
                    iter.remove();
                    return cartRepository.save(cart);
                }
            }
        }

        CartItem item = getOrCreateCartItemByProductId(cart, productId);
        item.setQuantity(quantity);

        return cartRepository.save(cart);
    }

    public CartDetail removeProducts(AppUserDetails userDetails, List<Long> productIds) {
        CartDetail cart = getCartByUser(userDetails);
        Iterator<CartItem> iter = cart.getCartItems().iterator();
        while (iter.hasNext()) {
            if (productIds.contains(iter.next().getProduct().getId())) {
                iter.remove();
            }
        }

        return cartRepository.save(cart);
    }

    private CartDetail getCartByUser(AppUserDetails userDetails) {
        AppUser user = new AppUser();
        user.setId(userDetails.getUserId());

        return cartRepository.findByUser(user);
    }

    private CartItem getOrCreateCartItemByProductId(CartDetail cart, long productId) {
        List<CartItem> items = cart.getCartItems();
        for (CartItem item : items) {
            if (item.getProduct().getId() == productId) {
                return item;
            }
        }

        CartItem item = new CartItem();
        item.setCartDetail(cart);
        item.setProduct(productRepository.findById(productId).orElse(null));
        item.setQuantity(0);
        items.add(item);

        return item;
    }

}
