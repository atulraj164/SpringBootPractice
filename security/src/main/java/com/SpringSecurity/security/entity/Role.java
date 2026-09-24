package com.SpringSecurity.security.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Table(name="role")
@Entity
@Getter
@Setter
public class Role {

	@Id
	@GeneratedValue( strategy=GenerationType.IDENTITY)
	private Integer roleid;
	private String rolename;

}
