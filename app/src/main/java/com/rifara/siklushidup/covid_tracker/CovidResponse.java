package com.rifara.siklushidup.covid_tracker;

import com.google.gson.annotations.SerializedName;

/*
* "cases": 548639971,
* "deaths": 6350239,
* "recovered": 523475632,
* */

public class CovidResponse {

	@SerializedName("recovered")
	private int recovered;

	@SerializedName("cases")
	private int cases;

	@SerializedName("deaths")
	private int deaths;


	public int getRecovered(){
		return recovered;
	}

	public int getCases(){
		return cases;
	}

	public int getDeaths(){
		return deaths;
	}

}