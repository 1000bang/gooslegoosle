package com.threebee.gooslegoosle.dto;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonPropertyOrder({ "access_token", "token_type", "refresh_token", "id_token", "expires_in", "scope",
			"refresh_token_expires_in" })

	public class OAuthToken {
 
		@JsonProperty("access_token")
		public String accessToken;
		@JsonProperty("token_type")
		public String tokenType;
		@JsonProperty("refresh_token")
		public String refreshToken;
		@JsonProperty("id_token")
		public String idToken;
		@JsonProperty("expires_in")
		public Integer expiresIn;
		@JsonProperty("scope")
		public String scope;
		@JsonProperty("refresh_token_expires_in")
		public Integer refreshTokenExpiresIn;
		@JsonIgnore
		private Map<String, Object> additionalProperties = new HashMap<String, Object>();

		@JsonAnyGetter
		public Map<String, Object> getAdditionalProperties() {
			return this.additionalProperties;
		}

		@JsonAnySetter
		public void setAdditionalProperty(String name, Object value) {
			this.additionalProperties.put(name, value);
		}

	}
