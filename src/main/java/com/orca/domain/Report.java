package com.orca.domain;

public class Report {
	
	private String type;
	private Integer quantity;
	private Survey firstSurvey;
	private Survey secondSurvey;
	private Survey thirdSurvey;
	private Survey fourthSurvey;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Survey getFirstSurvey() {
		return firstSurvey;
	}
	public void setFirstSurvey(Survey firstSurvey) {
		this.firstSurvey = firstSurvey;
	}
	public Survey getSecondSurvey() {
		return secondSurvey;
	}
	public void setSecondSurvey(Survey secondSurvey) {
		this.secondSurvey = secondSurvey;
	}
	public Survey getThirdSurvey() {
		return thirdSurvey;
	}
	public void setThirdSurvey(Survey thirdSurvey) {
		this.thirdSurvey = thirdSurvey;
	}
	public Survey getFourthSurvey() {
		return fourthSurvey;
	}
	public void setFourthSurvey(Survey fourthSurvey) {
		this.fourthSurvey = fourthSurvey;
	}
		
}
