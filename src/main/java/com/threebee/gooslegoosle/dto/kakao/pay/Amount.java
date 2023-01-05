package com.threebee.gooslegoosle.dto.kakao.pay;

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
@JsonPropertyOrder({ "total", "tax_free", "vat", "point", "discount", "green_deposit" })
@Generated("jsonschema2pojo")
public class Amount {

	@JsonProperty("total")
	public Integer total;
	@JsonProperty("tax_free")
	public Integer taxFree;
	@JsonProperty("vat")
	public Integer vat;
	@JsonProperty("point")
	public Integer point;
	@JsonProperty("discount")
	public Integer discount;
	@JsonProperty("green_deposit")
	public Integer greenDeposit;
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