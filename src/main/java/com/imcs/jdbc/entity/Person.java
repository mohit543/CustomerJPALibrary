package com.imcs.jdbc.entity;

import javax.persistence.MappedSuperclass;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@MappedSuperclass
public class Person {
	private String firstName;
	private String lastName;

	// partial method implementations
}
