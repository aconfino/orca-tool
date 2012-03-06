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
@Table (name = "Support")
public class Support {

	@Id
	@GeneratedValue
	private Integer id;
	@Range(min = 0, max = 5, errorCode="invalid.value")
	private Integer commercialSupport;
	@Range(min = 0, max = 5, errorCode="invalid.value")
	private Integer indemnification;
	@Range(min = 0, max = 5, errorCode="invalid.value")
	private Integer communitySupport;
	@OneToOne  
	@JoinColumn(name = "surveyId")
	private Survey survey;

	public void populate() {
		setCommercialSupport(3);
		setIndemnification(3);
		setCommunitySupport(3);
	}
	
	public double getCalculatedValue(){
		BigDecimal commercial = new BigDecimal(commercialSupport);
		BigDecimal indemn = new BigDecimal(indemnification);
		BigDecimal community = new BigDecimal(communitySupport);
		BigDecimal divisor = new BigDecimal(3);
		BigDecimal multiplicand = new BigDecimal(2);
		BigDecimal value = new BigDecimal("0");
		value = commercial.add(indemn).add(community);
		value = value.divide(divisor, 2, BigDecimal.ROUND_HALF_UP);
		value = value.multiply(multiplicand);
		return value.doubleValue();
	}

	public double getWeightedValue(Survey survey) {
		BigDecimal calculatedValue = new BigDecimal(getCalculatedValue());
		BigDecimal multiplicand = new BigDecimal(survey.getEvaluation().getSupportWeight());
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

	public Integer getCommercialSupport() {
		return commercialSupport;
	}

	public void setCommercialSupport(Integer commercialSupport) {
		this.commercialSupport = commercialSupport;
	}

	public Integer getIndemnification() {
		return indemnification;
	}

	public void setIndemnification(Integer indemnification) {
		this.indemnification = indemnification;
	}

	public Integer getCommunitySupport() {
		return communitySupport;
	}

	public void setCommunitySupport(Integer communitySupport) {
		this.communitySupport = communitySupport;
	}

	public Survey getSurvey() {
		return survey;
	}

	public void setSurvey(Survey survey) {
		this.survey = survey;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + commercialSupport;
		result = prime * result + communitySupport;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + indemnification;
		result = prime * result + ((survey == null) ? 0 : survey.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Support other = (Support) obj;
		if (commercialSupport != other.commercialSupport)
			return false;
		if (communitySupport != other.communitySupport)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (indemnification != other.indemnification)
			return false;
		if (survey == null) {
			if (other.survey != null)
				return false;
		} else if (!survey.equals(other.survey))
			return false;
		return true;
	}

}
