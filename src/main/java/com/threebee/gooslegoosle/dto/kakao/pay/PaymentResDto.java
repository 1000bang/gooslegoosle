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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"tid",
"tms_result",
"next_redirect_app_url",
"next_redirect_mobile_url",
"next_redirect_pc_url",
"android_app_scheme",
"ios_app_scheme",
"created_at"
}) 
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PaymentResDto {

@JsonProperty("tid")
public String tid;
@JsonProperty("tms_result")
public Boolean tmsResult;
@JsonProperty("next_redirect_app_url")
public String nextRedirectAppUrl;
@JsonProperty("next_redirect_mobile_url")
public String nextRedirectMobileUrl;
@JsonProperty("next_redirect_pc_url")
public String nextRedirectPcUrl;
@JsonProperty("android_app_scheme")
public String androidAppScheme;
@JsonProperty("ios_app_scheme")
public String iosAppScheme;
@JsonProperty("created_at")
public String createdAt;
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