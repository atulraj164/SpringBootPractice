package com.SpringSecurity.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringSecurity.security.entity.Role;
import com.SpringSecurity.security.repository.RoleRepository;

@Service
public class RoleService {
   @Autowired
   RoleRepository rolerepo;
   
   
   public Role saveRole(Role role) {
	   return rolerepo.save(role);
   }
   
}
