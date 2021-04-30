package main.model;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

public enum Role {
    USER(Set.of(Permission.USER)),
    MODERATOR(Set.of(Permission.USER, Permission.MODERATE));

    private final Set<Permission> securityPermissions;

    Role(Set<Permission> securityPermissions) {
        this.securityPermissions = securityPermissions;
    }

    public Set<Permission> getSecurityPermissions() {
        return securityPermissions;
    }

    public Set<SimpleGrantedAuthority> getAuthorities() {
        return securityPermissions.stream()
                .map(e -> new SimpleGrantedAuthority(e.getPermission()))
                .collect(Collectors.toSet());
    }

}
