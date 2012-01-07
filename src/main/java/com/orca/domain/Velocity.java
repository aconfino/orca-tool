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
@Table (name = "Velocity")
public class Velocity {

	@Id
	@GeneratedValue
	private Integer id;
	@Range(min = 0, max = 5, errorCode="invalid.value")
	private Integer featureActual;
	@Range(min = 0, max = 5, errorCode="invalid.value")
	private Integer patchActual;
	@OneToOne  
	@JoinColumn(name = "surveyId")
	private Survey survey;

	public void populate() {
		setFeatureActual(3);
		setPatchActual(3);
	}
	
	public double getCalculatedValue(){
		BigDecimal feature = new BigDecimal(featureActual);
		BigDecimal patch = new BigDecimal(patchActual);
		BigDecimal divisor = new BigDecimal(2);
		BigDecimal multiplicand = new BigDecimal(2);
		BigDecimal value = new BigDecimal("0");
		value = feature.add(patch);
		value = value.divide(divisor, 2, BigDecimal.ROUND_HALF_UP);
		value = value.multiply(multiplicand);
		return value.doubleValue();
	}

	public double getWeightedValue(Survey survey) {
		BigDecimal calculatedValue = new BigDecimal(getCalculatedValue());
		BigDecimal multiplicand = new BigDecimal(survey.getEvaluation().getVelocityWeight());
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

	public Integer getFeatureActual() {
		return featureActual;
	}

	public void setFeatureActual(Integer featureActual) {
		this.featureActual = featureActual;
	}

	public Integer getPatchActual() {
		return patchActual;
	}

	public void setPatchActual(Integer patchActual) {
		this.patchActual = patchActual;
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
		result = prime * result + featureActual;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + patchActual;
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
		Velocity other = (Velocity) obj;
		if (featureActual != other.featureActual)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (patchActual != other.patchActual)
			return false;
		if (survey == null) {
			if (other.survey != null)
				return false;
		} else if (!survey.equals(other.survey))
			return false;
		return true;
	}

}
