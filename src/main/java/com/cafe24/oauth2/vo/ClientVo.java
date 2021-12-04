package com.cafe24.oauth2.vo;

import java.util.List;

public class ClientVo {
	private String id;
	private String secret;
	private String[] callbackUrl;
	private String[] grantType;
	private String[] scopes;
	
	public ClientVo(String id, String secret, String[] callbackUrl, String[] grantType, String[] scopes) {
		this.id =id;
		this.secret = secret;
		this.callbackUrl = callbackUrl;
		this.grantType = grantType;
		this.scopes = scopes;
	}

	public String getId() {
		return id;
	}

	public String getSecret() {
		return secret;
	}

	public String[] getCallbackUrl() {
		return callbackUrl;
	}

	public String[] getGrantType() {
		return grantType;
	}

	public String[] getScopes() {
		return scopes;
	}

	
}
