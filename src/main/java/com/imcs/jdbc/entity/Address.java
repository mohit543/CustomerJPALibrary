package com.imcs.jdbc.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString

//@Entity
@Embeddable
public class Address {
	
	@Column(name = "address_1", length = 30)
	private String addressLine1;
	
	@Column(name = "address_2")
	private String addressLine2;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "state")
	@NotNull
	@Enumerated(EnumType.STRING)
	private State state;
	
	@Embedded
	private ZipCode postalCode;
	
	@Column(name = "country")
	private String country;
	
	
	public Address(String addressLine1, String addressLine2, String city, String stateName, String postalCode,
			String country) {
		super();
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.state = State.getState(stateName);
		this.postalCode = new ZipCode(postalCode);
		this.country = country;
	}
	
	//Constructors
	
	
	// Some address methods.
}
