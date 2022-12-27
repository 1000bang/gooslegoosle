
package com.threebee.gooslegoosle.dto.kakao.login;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "connected_at", "properties", "kakao_account" })

public class KakaoProfileDto {

	@JsonProperty("id")
	public Long id;
	@JsonProperty("connected_at")
	public String connectedAt;
	@JsonProperty("properties")
	public Properties properties;
	@JsonProperty("kakao_account")
	public KakaoAccount kakaoAccount;
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

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonPropertyOrder({ "nickname" })

	// .......................................
	// 내부클래스
	public class Properties {

		@JsonProperty("nickname")
		public String nickname;
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

	// .......................................
	// 내부클래스
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonPropertyOrder({ "profile_nickname_needs_agreement", "profile", "has_email", "email_needs_agreement",
			"is_email_valid", "is_email_verified", "email" })
	public class KakaoAccount {

		@JsonProperty("profile_nickname_needs_agreement")
		public Boolean profileNicknameNeedsAgreement;
		@JsonProperty("profile")
		public Profile profile;
		@JsonProperty("has_email")
		public Boolean hasEmail;
		@JsonProperty("email_needs_agreement")
		public Boolean emailNeedsAgreement;
		@JsonProperty("is_email_valid")
		public Boolean isEmailValid;
		@JsonProperty("is_email_verified")
		public Boolean isEmailVerified;
		@JsonProperty("email")
		public String email;
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

	// .......................................
	// 내부클래스
	
	
}
