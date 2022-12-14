package com.dxc.qdang.ecommercedemo.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import com.dxc.qdang.ecommercedemo.util.SerializableVersion;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class CartDetail implements Serializable {

    private static final long serialVersionUID = SerializableVersion.SERIAL_VERSION_UID;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @OneToOne(optional = true)
    @JoinColumn(unique = true)
    private AppUser user;

    @OneToMany(mappedBy = "cartDetail", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<CartItem> cartItems = new ArrayList<>();

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    @Transient
    private Date currentDate = new Date();

    @Column(updatable = false)
    private Date createdAt = currentDate;

    private Date modifiedAt = currentDate;

    @Transient
    public int getGrandTotal() {
        return cartItems.stream().mapToInt(item -> item.getProduct().getPrice() * item.getQuantity()).sum();
    }

    @Transient
    public int getTotalQuantity() { return cartItems.stream().mapToInt(CartItem::getQuantity).sum(); }

}
