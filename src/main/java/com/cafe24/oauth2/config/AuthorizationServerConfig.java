package com.cafe24.oauth2.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.builders.InMemoryClientDetailsServiceBuilder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

import com.cafe24.oauth2.vo.ClientVo;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
    	List<ClientVo> clientList = new ArrayList<ClientVo>();
    	clientList.add(
    			// Authorization Code Grant Type
    			new ClientVo(
    					"client", 
    					"{bcrypt}$2a$10$iP9ejueOGXO29.Yio7rqeuW9.yOC4YaV8fJp3eIWbP45eZSHFEwMG", 
    					new String[] {"http://localhost:8080/callback"}, 
    					new String[] {"authorization_code", "refresh_token"}, 
    					new String[] {"read_data"}
    					)
    			);
    	
    	clientList.add(
    			// Client Credentials Grant Type
    			new ClientVo(
    					"client_crudential", 
    					"{bcrypt}$2a$10$iP9ejueOGXO29.Yio7rqeuW9.yOC4YaV8fJp3eIWbP45eZSHFEwMG", 
    					new String[] {"http://localhost:8080/callback"}, 
    					new String[] {"client_credentials"}, 
    					new String[] {"read_data", "write_data"}
    					)
    			);
    	
    	InMemoryClientDetailsServiceBuilder inMemoryBuilder = clients.inMemory ();
        for (ClientVo clientVo: clientList) {
            inMemoryBuilder
                .withClient ( clientVo.getId() )
                .secret ( clientVo.getSecret() )
                .scopes ( clientVo.getScopes() )
                .redirectUris(clientVo.getCallbackUrl())
                .authorizedGrantTypes ( clientVo.getGrantType() );
        }
    	
        // https://cheese10yun.github.io/spring-oauth2-provider/
    	// http://localhost:8080/oauth/authorize?client_id=client&redirect_uri=http://localhost:8080/callback&response_type=code&scope=read_data
       
                
    }
}