package com.threebee.gooslegoosle.dto.naver;

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
@JsonPropertyOrder({ "resultcode", "message", "response" })
@Generated("jsonschema2pojo")
public class NaverProfileDto {

	@JsonProperty("resultcode")
	public String resultcode;
	@JsonProperty("message")
	public String message;
	@JsonProperty("response")
	public Response response;
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
	@JsonPropertyOrder({ "id", "nickname", "profile_image", "email", "name" })
	@Generated("jsonschema2pojo")
	public class Response {

		@JsonProperty("id")
		public String id;
		@JsonProperty("nickname")
		public String nickname;
		@JsonProperty("profile_image")
		public String profileImage;
		@JsonProperty("email")
		public String email;
		@JsonProperty("name")
		public String name;
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

}