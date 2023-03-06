package com.shopping.items.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Builder
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDetailsOfUser {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer orderId;
	private UserDetails userDetails;
	@OneToMany(targetEntity=ItemEntity.class,  fetch=FetchType.EAGER)
	private List<Object> itemEntity;
	private String firstName=""
			,lastName=""
			,emailAddress=""
			,phoneNumber=""
			,pincode=""
			,deliveryAddress=""
			,paymentType="";
	private LocalDate orderedOn;
	private LocalTime orderedAt;
	private int orderQuantity;
	
	public OrderDetailsOfUser(Integer orderId, UserDetails userDetails, List< Object> itemEntity,
			String firstName, String lastName, String emailAddress, String phoneNumber, String pincode,
			String deliveryAddress, String paymentType, LocalDate orderedOn, LocalTime orderedAt, int orderQuantity) {
		super();
		this.orderId = orderId;
		this.userDetails = userDetails;
		this.itemEntity = itemEntity;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
		this.phoneNumber = phoneNumber;
		this.pincode = pincode;
		this.deliveryAddress = deliveryAddress;
		this.paymentType = paymentType;
		this.orderedOn = orderedOn;
		this.orderedAt = orderedAt;
		this.orderQuantity = orderQuantity;
	}
}
