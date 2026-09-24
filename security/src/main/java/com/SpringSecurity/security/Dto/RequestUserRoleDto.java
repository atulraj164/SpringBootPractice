package com.SpringSecurity.security.Dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class RequestUserRoleDto {
	private String username;
    private String password;
    private String rolename; 
    
}
