package com.dxc.qdang.ecommercedemo.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

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
@Table(name = "app_user")
public class AppUser {

    public enum EnabledStatus {
        Y,
        N
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @NonNull
    @Column(name = "password", nullable = false)
    private String password;

    @NonNull
    @Column(name = "display_name", nullable = false)
    private String displayName;

    @Column(name = "profile_picture_url")
    private String profilePictureUrl;

    @NonNull
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(nullable = false)
    private AppAuthority authority;

    @Column(name = "is_enabled", length = 1, nullable = false)
    @Enumerated(EnumType.STRING)
    private EnabledStatus isEnabled = EnabledStatus.Y;

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    @Transient
    Date currentDate = new Date();

    @Column(name = "last_login_at")
    private Date lastLoginAt = currentDate;

    @Column(name = "created_at")
    private Date createdAt = currentDate;

    @Column(name = "modified_at")
    private Date modifiedAt = currentDate;

}
