package com.pritam.idm.oauth2.service;

import java.util.Map;

import com.pritam.idm.dto.FacebookOAuth2UserInfo;
import com.pritam.idm.dto.GoogleOAuth2UserInfo;
import com.pritam.idm.dto.OAuth2UserInfo;
import com.pritam.idm.model.AuthProvider;

public class OAuth2UserInfoFactory {

	public static OAuth2UserInfo getOAuth2UserInfo(String registrationId, Map<String, Object> attributes) {
		AuthProvider authProvider = AuthProvider.valueOf(registrationId);
		OAuth2UserInfo oAuth2UserInfo = null ;
		switch (authProvider) {
		case google:
			oAuth2UserInfo= new GoogleOAuth2UserInfo(attributes);
			break;
		case facebook:
			oAuth2UserInfo= new FacebookOAuth2UserInfo(attributes);
			break;
		case local:
			//TODO: check
			break;
		default:
			break;
		}
		return oAuth2UserInfo;
	}
}
