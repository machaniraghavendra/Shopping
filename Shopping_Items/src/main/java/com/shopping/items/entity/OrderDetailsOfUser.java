package com.shopping.items.entity;

import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@Entity
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDetailsOfUser {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer orderId;
	private UUID uuidId;
	private UserDetails userDetails;
	@OneToMany(targetEntity = ItemEntity.class, fetch = FetchType.EAGER)
	private List<Object> itemEntity;
	private String firstName = "", lastName = "", emailAddress = "", phoneNumber = "", pincode = "",
			deliveryAddress = "", paymentType = "";
	private String orderedOn;
	private String orderedAt;
	private int orderQuantity;

}
