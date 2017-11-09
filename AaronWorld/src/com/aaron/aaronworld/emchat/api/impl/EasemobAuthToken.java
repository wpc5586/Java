package com.aaron.aaronworld.emchat.api.impl;

import com.aaron.aaronworld.emchat.api.AuthTokenAPI;
import com.aaron.aaronworld.emchat.comm.TokenUtil;


public class EasemobAuthToken implements AuthTokenAPI{

	@Override
	public Object getAuthToken(){
		return TokenUtil.getAccessToken();
	}
}
