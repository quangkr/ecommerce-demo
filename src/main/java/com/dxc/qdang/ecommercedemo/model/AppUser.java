package com.dxc.qdang.ecommercedemo.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

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

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "app_user_authority",
            joinColumns = @JoinColumn(name = "app_user_id"),
            inverseJoinColumns = @JoinColumn(name = "app_authority_id"))
    private List<AppAuthority> authorities;

    @Column(name = "is_enabled", length = 1, nullable = false)
    @Enumerated(EnumType.STRING)
    private EnabledStatus isEnabled = EnabledStatus.Y;

    @Column(name = "last_login_at")
    private Date lastLoginAt = new Date();

    @Column(name = "created_at")
    private Date createdAt = new Date();

    @Column(name = "modified_at")
    private Date modifiedAt = new Date();

}
