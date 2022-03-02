package com.dxc.qdang.ecommercedemo.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
import lombok.Setter;

@NoArgsConstructor
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

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "display_name", nullable = false)
    private String displayName;

    @Column(name = "profile_picture_url")
    private String profilePictureUrl;

    @ManyToMany
    @JoinTable(
            name = "app_user_authority",
            joinColumns = @JoinColumn(name = "app_user_id"),
            inverseJoinColumns = @JoinColumn(name = "app_authority_id"))
    private Set<AppAuthority> authorities;

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
