package com.imcs.jdbc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orderlineitem")
public class OrderLineItem {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long orderLineNumber;

	@Column(name = "product_code")
	private Integer productCode;

	@Column(name = "product_name")
	private String productName;

	@Column(name = "product_description")
	private String productDescription;

	@Column(name = "quantity")
	private Integer quantityOrdered;

	@Column(name = "price_each")
	private Double priceEach;

	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;

}
