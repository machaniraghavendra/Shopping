package com.shopping.items.entity;

import java.io.Serializable;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(name = "UserStory")
@Getter
@Setter
@NoArgsConstructor
@ToString
@Builder
@AllArgsConstructor
public class UserDetails  implements Serializable {

	private static final long serialVersionUID = 6139227758979754608L;

	private String userName;
	private String userEmail;
	private String mobileNumber;
	
}
