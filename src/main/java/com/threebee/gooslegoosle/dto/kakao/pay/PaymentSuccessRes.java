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
@JsonPropertyOrder({ "cid", "aid", "tid", "partner_user_id", "partner_order_id", "payment_method_type", "item_name",
		"quantity", "amount", "card_info", "created_at", "approved_at" })
@Generated("jsonschema2pojo")
public class PaymentSuccessRes {

	@JsonProperty("cid")
	public String cid;
	@JsonProperty("aid")
	public String aid;
	@JsonProperty("tid")
	public String tid;
	@JsonProperty("partner_user_id")
	public String partnerUserId;
	@JsonProperty("partner_order_id")
	public String partnerOrderId;
	@JsonProperty("payment_method_type")
	public String paymentMethodType;
	@JsonProperty("item_name")
	public String itemName;
	@JsonProperty("quantity")
	public Integer quantity;
	@JsonProperty("amount")
	public Amount amount;
	@JsonProperty("card_info")
	public CardInfo cardInfo;
	@JsonProperty("created_at")
	public String createdAt;
	@JsonProperty("approved_at")
	public String approvedAt;
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