package com.orca.domain;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springmodules.validation.bean.conf.loader.annotation.handler.Range;

@Entity
@Table (name = "MarketPenetration")
public class MarketPenetration {

	@Id
	@GeneratedValue
	private Integer id;
	@Range(min = 0, max = 5, errorCode="invalid.value")
	private Integer marketPenetrationScore;
	@OneToOne
	@JoinColumn(name = "surveyId")
	private Survey survey;

	public void populate() {
		setMarketPenetrationScore(3);
	}
	
	public double getCalculatedValue(){
		BigDecimal value = new BigDecimal(marketPenetrationScore);
		BigDecimal multiplicand = new BigDecimal(2);
		value = value.multiply(multiplicand);
		return value.doubleValue();
	}
	
	public double getWeightedValue(Survey survey) {
		BigDecimal calculatedValue = new BigDecimal(getCalculatedValue());
		BigDecimal multiplicand = new BigDecimal(survey.getEvaluation().getMarketWeight());
		calculatedValue = calculatedValue.multiply(multiplicand);
		BigDecimal divisor = new BigDecimal(100);
		calculatedValue = calculatedValue.divide(divisor, 2, BigDecimal.ROUND_HALF_UP);
		return calculatedValue.doubleValue();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getMarketPenetrationScore() {
		return marketPenetrationScore;
	}

	public void setMarketPenetrationScore(Integer marketPenetrationScore) {
		this.marketPenetrationScore = marketPenetrationScore;
	}

	public Survey getSurvey() {
		return survey;
	}

	public void setSurvey(Survey survey) {
		this.survey = survey;
	}

}
