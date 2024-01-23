package com.example.weatherapp.model;

import com.google.gson.annotations.SerializedName;

public class CurrentWeatherResponse{

	@SerializedName("current")
	private Current current;

	@SerializedName("location")
	private Location location;

	public Current getCurrent(){
		return current;
	}

	public Location getLocation(){
		return location;
	}
}