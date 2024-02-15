package org.ahmedukamel.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

@Getter
@Setter
@Entity
@Table(name = "customers")
public class Customer implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerId;
    @Column(unique = true, nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(unique = true, nullable = false)
    private String phone;
    @Column(nullable = false)
    private Boolean enabled;
    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Role role;
    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Cart cart;
    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Wishlist wishlist;

    @JsonIgnore
    @ManyToMany(mappedBy = "customers", cascade = CascadeType.ALL)
    private Set<Notification> notifications = new HashSet<>();
    @JsonIgnore
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<CustomerDetail> customerDetails = new HashSet<>();
    @JsonIgnore
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Address> addresses = new HashSet<>();
    @JsonIgnore
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Review> reviews = new HashSet<>();
    @JsonIgnore
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Order> orders = new HashSet<>();
    @JsonIgnore
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Like> likes = new HashSet<>();
    @JsonIgnore
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Demand> demands = new HashSet<>();
    @JsonIgnore
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ReviewReport> reports = new HashSet<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(this.role.name()));
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }
}
