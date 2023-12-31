package com.nagarro.tshirt;

import com.nagarro.enums.Color;
import com.nagarro.enums.Gender;
import com.nagarro.enums.OutputPreference;
import com.nagarro.enums.Size;

public class Tshirt {
	
	 private String id;
	 private String name;
	 private Color color;
	 private Gender gender;
  	 private Size size;
     private String avalibilty; 
     private double price;
     private double rating;
     private OutputPreference outputPreference;
     
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public Size getSize() {
		return size;
	}
	public void setSize(Size size) {
		this.size = size;
	}
	public String getAvalibilty() {
		return avalibilty;
	}
	public void setAvalibilty(String avalibilty) {
		this.avalibilty = avalibilty;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public OutputPreference getOutputPreference() {
		return outputPreference;
	}
	//public void setOutputPreference(OutputPreference outputPreference) {
	//	this.outputPreference = outputPreference;
	//}
	public void setOutputPreference(OutputPreference outputPreference) {
		this.outputPreference = outputPreference;
		
	}
}
