package com.shopping.items.entity;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@ToString
@Builder
public class Bot {
	private UUID id;
	private String userMessage;
	private String botMessage;
	private String userMessagedAt;
	private String botReturnedAt;
	private UserDetails userDetails;
	
	public Bot(UUID id, String userMessage, String botMessage, String userMessagedAt, String botReturnedAt,
			UserDetails userDetails) {
		super();
		this.id = id;
		this.userMessage = userMessage;
		this.botMessage = botMessage;
		this.userMessagedAt = userMessagedAt;
		this.botReturnedAt = botReturnedAt;
		this.userDetails = userDetails;
	}
	
}
