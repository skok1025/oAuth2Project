package com.cafe24.oauth2.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class ClientVo {
	private String id;
	private String secret;
	private String[] callbackUrl;
	private String[] grantType;
	private String[] scopes;	
}
