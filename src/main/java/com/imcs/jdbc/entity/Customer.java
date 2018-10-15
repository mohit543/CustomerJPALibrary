package com.imcs.jdbc.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
//@ToString
@ToString
@Data
@Entity
@Table(name = "customer")
public class Customer extends Person {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "customer_id")
	private Long custID;

	@Column(name = "customer_Name")
	private String customerName;

	@Column(name = "credit_Limit")
	private Double creditLimit;

	@Column(name = "sales_Rep_ID")
	private Integer salesRepID;

	@Column(name = "phone_Number")
	private String phoneNumber;

	// @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@Embedded
	private Address address;

	@OneToMany(mappedBy = "customer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Order> orders;

	@OneToMany(mappedBy = "customer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Payments> payments;

	// Constructors
	public Customer() {

	}

	public Customer(Long custID, String name) {
		this.custID = custID;
		this.customerName = name;
	}

	public Customer(Long custID, String name, Double creditLimit) {
		this.custID = custID;
		this.customerName = name;
		this.creditLimit = creditLimit;
	}

	public Customer(Long custID, String customerName, Double creditLimit, Integer salesRepID, String phoneNumber) {
		super();
		this.custID = custID;
		this.customerName = customerName;
		this.creditLimit = creditLimit;
		this.salesRepID = salesRepID;
		this.phoneNumber = phoneNumber;
	}

	public Customer(Long custID, String customerName, Double creditLimit, Integer salesRepID, String phoneNumber,
			Address address) {
		super();
		this.custID = custID;
		this.customerName = customerName;
		this.creditLimit = creditLimit;
		this.salesRepID = salesRepID;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}

	public void doSomethingA() {
		System.out.println("Doing something .. A");
	}

	public void doSomethingB() {
		System.out.println("Doing something .. B");
	}

	public boolean hasCredit() {
		return creditLimit > 0;
	}
	// Some customer related methods

}
