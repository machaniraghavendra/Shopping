package com.shopping.items.entity;

import java.io.Serializable;
import javax.persistence.Table;

import com.shop.life.entity.UserEntity;

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
public class UserDetails extends UserEntity implements Serializable {

	private static final long serialVersionUID = 6139227758979754608L;

}
