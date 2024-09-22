package com.ecommerce.security;

import com.ecommerce.entity.Role;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@AllArgsConstructor
public class SecurityAuthority implements GrantedAuthority {

    private Role role;

    @Override
    public String getAuthority() {
        return role.getRole();
    }
}
