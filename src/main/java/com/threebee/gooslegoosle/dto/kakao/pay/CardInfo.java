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
@JsonPropertyOrder({ "interest_free_install", "bin", "card_type", "card_mid", "approved_id", "install_month",
		"purchase_corp", "purchase_corp_code", "issuer_corp", "issuer_corp_code", "kakaopay_purchase_corp",
		"kakaopay_purchase_corp_code", "kakaopay_issuer_corp", "kakaopay_issuer_corp_code" })
@Generated("jsonschema2pojo")
public class CardInfo {

	@JsonProperty("interest_free_install")
	public String interestFreeInstall;
	@JsonProperty("bin")
	public String bin;
	@JsonProperty("card_type")
	public String cardType;
	@JsonProperty("card_mid")
	public String cardMid;
	@JsonProperty("approved_id")
	public String approvedId;
	@JsonProperty("install_month")
	public String installMonth;
	@JsonProperty("purchase_corp")
	public String purchaseCorp;
	@JsonProperty("purchase_corp_code")
	public String purchaseCorpCode;
	@JsonProperty("issuer_corp")
	public String issuerCorp;
	@JsonProperty("issuer_corp_code")
	public String issuerCorpCode;
	@JsonProperty("kakaopay_purchase_corp")
	public String kakaopayPurchaseCorp;
	@JsonProperty("kakaopay_purchase_corp_code")
	public String kakaopayPurchaseCorpCode;
	@JsonProperty("kakaopay_issuer_corp")
	public String kakaopayIssuerCorp;
	@JsonProperty("kakaopay_issuer_corp_code")
	public String kakaopayIssuerCorpCode;
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