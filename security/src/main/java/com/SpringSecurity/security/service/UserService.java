package com.SpringSecurity.security.service;


import java.util.Optional;
import java.util.Set;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.SpringSecurity.security.Dto.RequestUserRoleDto;
import com.SpringSecurity.security.entity.Role;
import com.SpringSecurity.security.entity.User;
import com.SpringSecurity.security.repository.RoleRepository;
import com.SpringSecurity.security.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	
   private final UserRepository userrepo;
   private final RoleRepository rolerepo;
   private final PasswordEncoder passswordEncoder;
    
    public User userRegistration(RequestUserRoleDto req) {
    	
    	Role role= rolerepo.findByrolename(req.getRolename())
    			.orElseThrow(()->new RuntimeException("role not found"));
    	 User user=new User();
    	 user.setUsername(req.getUsername());
    	 user.setPassword(passswordEncoder.encode(req.getPassword()));
    	 user.setRoles(Set.of(role));
    	 return userrepo.save(user);
    	 
    }
    
}
