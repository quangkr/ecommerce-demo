package com.dxc.qdang.ecommercedemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dxc.qdang.ecommercedemo.dto.ShippingDetailDto;
import com.dxc.qdang.ecommercedemo.model.AppUser;
import com.dxc.qdang.ecommercedemo.model.CartDetail;
import com.dxc.qdang.ecommercedemo.model.CartItem;
import com.dxc.qdang.ecommercedemo.model.OrderDetail;
import com.dxc.qdang.ecommercedemo.model.OrderItem;
import com.dxc.qdang.ecommercedemo.repository.CartRepository;
import com.dxc.qdang.ecommercedemo.repository.OrderRepository;
import com.dxc.qdang.ecommercedemo.security.AppUserDetails;

@Service
@Transactional
public class OrderService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private OrderRepository orderRepository;

    public List<OrderDetail> getAllOrders(AppUserDetails userDetails) {
        AppUser user = new AppUser();
        user.setId(userDetails.getUserId());

        return orderRepository.findAllByUser(user);
    }

    public OrderDetail addOrder(AppUserDetails userDetails, ShippingDetailDto shippingDetailDto) {
        AppUser user = new AppUser();
        user.setId(userDetails.getUserId());
        OrderDetail newOrder = new OrderDetail();
        newOrder.setUser(user);
        newOrder.setFullName(shippingDetailDto.getFullName());
        newOrder.setPhoneNumber(shippingDetailDto.getPhoneNumber());
        newOrder.setAddress(shippingDetailDto.getAddress());
        newOrder.setWard(shippingDetailDto.getWard());
        newOrder.setDistrict(shippingDetailDto.getDistrict());
        newOrder.setCity(shippingDetailDto.getCity());
        newOrder = orderRepository.save(newOrder);

        List<OrderItem> orderItems = newOrder.getOrderItems();
        CartDetail cart = cartRepository.findByUser(user);
        for (CartItem cartItem : cart.getCartItems()) {
            OrderItem orderItem = new OrderItem();

            orderItem.setOrderDetail(newOrder);
            orderItem.setProduct(cartItem.getProduct());
            orderItem.setQuantity(cartItem.getQuantity());

            orderItems.add(orderItem);
        }

        cart.getCartItems().clear();
        cartRepository.save(cart);

        return orderRepository.save(newOrder);
    }

}
