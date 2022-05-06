package com.traveler.entities;

import java.util.List;

public class Backpack {

	private String id;
	private String distance;
    private String bodyWeight;
	private String date;
	private String timeOfYear;
	private Double requiredCalories;
	private Double requiredWater; // in Liters
	private List<String> foodItems;
	private List<String> personalBelongings;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getDistance() {
		return distance;
	}
	public void setDistance(String distance) {
		this.distance = distance;
	}
	public String getBodyWeight() {
		return bodyWeight;
	}
	public void setBodyWeight(String bodyWeight) {
		this.bodyWeight = bodyWeight;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTimeOfYear() {
		return timeOfYear;
	}
	public void setTimeOfYear(String timeOfYear) {
		this.timeOfYear = timeOfYear;
	}
	
	public Double getRequiredCalories() {
		return requiredCalories;
	}
	public void setRequiredCalories(Double requiredCalories) {
		this.requiredCalories = requiredCalories;
	}
	public Double getRequiredWater() {
		return requiredWater;
	}
	public void setRequiredWater(Double requiredWater) {
		this.requiredWater = requiredWater;
	}
	public List<String> getFoodItems() {
		return foodItems;
	}
	public void setFoodItems(List<String> foodItems) {
		this.foodItems = foodItems;
	}
	public List<String> getPersonalBelongings() {
		return personalBelongings;
	}
	public void setPersonalBelongings(List<String> personalBelongings) {
		this.personalBelongings = personalBelongings;
	}
	
	@Override
	public String toString() {
		return "Kuprinė [atstumas=" + distance + ", kūno svoris=" + bodyWeight + ", data=" + date + ", metų laikas="
				+ timeOfYear + ", kalorijų kiekis=" + requiredCalories + ", vandens kiekis=" + requiredWater
				+ ", rekuomenduojami maisto produktai=" + foodItems + ", rekuomenduojami daiktai=" + personalBelongings + "]";
	}
}
