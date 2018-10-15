package com.imcs.jdbc.entity;

import javax.persistence.Embeddable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

@Embeddable
public class ZipCode {

	String value;

	public ZipCode(String value) {
		this.value = value;
	}

	public String getString() {
		return value;
	}

}