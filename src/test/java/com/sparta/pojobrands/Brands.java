package com.sparta.pojobrands;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Brands{

	@JsonProperty("brands")
	private List<BrandsItem> brands;

	@JsonProperty("responseCode")
	private int responseCode;

	public List<BrandsItem> getBrands(){
		return brands;
	}

	public int getResponseCode(){
		return responseCode;
	}
}