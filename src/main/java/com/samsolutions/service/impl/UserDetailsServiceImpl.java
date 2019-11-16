package com.samsolutions.service.impl;

import com.samsolutions.converter.UserConverter;
import com.samsolutions.dto.data.RoleDataDTO;
import com.samsolutions.dto.data.UserDataDTO;
import com.samsolutions.roles.Roles;
import com.samsolutions.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

/**
 * Implements the methods defined in the UserDetails service, needs for security.
 *
 * @author Vladislav Brazovskij <u.brazouski@sam-solutions.com>
 * @package com.samsolutions.service.impl
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Autowired
    private UserConverter userConverter;

    @Override
    @Transactional(readOnly = true, propagation = Propagation.NESTED)
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        UserDataDTO userDataDTO = userService.findByUsername(username);

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (Roles role : Roles.values()) {
            for (RoleDataDTO userRole : userDataDTO.getRoles()) {
                if (role.getAuthority().equals(userRole.getName())) {
                    grantedAuthorities.add(new SimpleGrantedAuthority(role.getAuthority()));
                }
            }
        }

        return new org.springframework.security.core.userdetails.User(userDataDTO.getUsername(), userDataDTO.getPassword(), grantedAuthorities);
    }
}
