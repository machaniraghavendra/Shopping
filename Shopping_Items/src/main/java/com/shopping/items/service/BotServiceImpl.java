package com.shopping.items.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.shopping.items.entity.Bot;

import org.springframework.util.StringUtils;

@Service
public class BotServiceImpl implements BotService{
	private static final String HI="hi";
	private static final String HI_RESPONSE="Hello, Ask me anything in shopping application";
	private static final String HELLO="hello";
	private static final String HOW_ARE_YOU="how are you";
	private static final String HOW_ARE_YOU_RESPONSE="Yahh Thanks for asking ! I'm fine and i'm here to help with page links";
	private static final String CART_PAGE="cart";
	private static final String CART_PAGE_RESPONSE="Sure! Here is the link tap on it http://localhost:3000/cart";
	private static final String ORDER_PAGE="orders";
	private static final String ORDER_PAGE_RESPONSE="Sure! Here is the link tap on it http://localhost:3000/orders";
	private static final String WISHLIST_PAGE="wishlist";
	private static final String WISHLIST_PAGE_RESPONSE="Sure! Here is the link tap on it http://localhost:3000/wishlist";
	private static final String SETTING_PAGE="setting";
	private static final String SETTING_PAGE_RESPONSE="Sure! Here is the link tap on it http://localhost:3000/profile/settings";
	private static final String ERROR_MSGE="Sorry I can't able to find with your query !";

	private static List<Bot> responses=new ArrayList<>();
	
	@SuppressWarnings("deprecation")
	@Override
	public void queryReponse(Bot incomeBot) {
		incomeBot.setUserMessage(incomeBot.getUserMessage().trim());
		if(!StringUtils.isEmpty(incomeBot.getUserMessage())) {
			if (HI.contains(incomeBot.getUserMessage().toLowerCase())||HELLO.contains(incomeBot.getUserMessage().toLowerCase())) {
				botListAdder(botBulider(incomeBot, HI_RESPONSE));
			} else if(CART_PAGE.contains(incomeBot.getUserMessage().toLowerCase())) {
				botListAdder(botBulider(incomeBot, CART_PAGE_RESPONSE));
			}
			else if(WISHLIST_PAGE.contains(incomeBot.getUserMessage().toLowerCase())) {
				botListAdder(botBulider(incomeBot, WISHLIST_PAGE_RESPONSE));
			}
			else if(HOW_ARE_YOU.contains(incomeBot.getUserMessage().toLowerCase())) {
				botListAdder(botBulider(incomeBot, HOW_ARE_YOU_RESPONSE));
			}
			else if(ORDER_PAGE.contains(incomeBot.getUserMessage().toLowerCase())) {
				botListAdder(botBulider(incomeBot, ORDER_PAGE_RESPONSE));
			}
			else if(SETTING_PAGE.contains(incomeBot.getUserMessage().toLowerCase())) {
				botListAdder(botBulider(incomeBot, SETTING_PAGE_RESPONSE));
			}
			else {
				botListAdder(botBulider(incomeBot, ERROR_MSGE));
			}
		}
	}
	
	@SuppressWarnings("static-access")
	private static  Bot botBulider(Bot incomeBot, String message) {
		return new Bot().builder().id(UUID.randomUUID())
				.userMessage(incomeBot.getUserMessage())
				.botMessage(message)
				.botReturnedAt(new OrderDetailsServImpl().getTime())
				.userMessagedAt(new OrderDetailsServImpl().getTime())
				.userDetails(incomeBot.getUserDetails())
				.build();
	}
	
	private static void botListAdder(Bot incomeBot) {
		responses.add(incomeBot);
	}
	
	public void listClear(String userEmail) {
		responses.removeAll(responses.stream()
				.filter(a->a.getUserDetails().getUserEmail().equalsIgnoreCase(userEmail))
				.collect(Collectors.toList()));
	}
	
	public List<Bot> viewAllResponse(){
		return responses;
	}
}
