package com.orca.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springmodules.validation.bean.conf.loader.annotation.handler.Range;

@Entity
@Table(name = "CodeDesign")
public class CodeDesign {

	@Id
	@Column(name = "id")
	@GeneratedValue
	private Integer id;
	@Range(min = 0, max = 5, errorCode="invalid.value")
	private Integer objectOriented;
	@Range(min = 0, max = 5, errorCode="invalid.value")
	private Integer understandability;
	@Range(min = 0, max = 5, errorCode="invalid.value")
	private Integer extensibility;
	@Range(min = 0, max = 5, errorCode="invalid.value")
	private Integer testability;
	@OneToOne  
	@JoinColumn(name = "surveyId")
	private Survey survey;

	public void populate(){
		setObjectOriented(3);
		setUnderstandability(3);
		setExtensibility(3);
		setTestability(3);
	}
	
	public double getCalculatedValue() {
		BigDecimal objOriented = new BigDecimal(objectOriented);
		BigDecimal understandable = new BigDecimal(understandability);
		BigDecimal extensible = new BigDecimal(extensibility);
		BigDecimal testable = new BigDecimal(testability);
		BigDecimal divisor = new BigDecimal(4);
		BigDecimal multiplicand = new BigDecimal(2);
		BigDecimal value = new BigDecimal("0");
		value = objOriented.add(understandable).add(extensible).add(testable);
		value = value.divide(divisor, 2, BigDecimal.ROUND_HALF_UP);
		value = value.multiply(multiplicand);
		return value.doubleValue();
	}
	
	public double getWeightedValue(Survey survey) {
		BigDecimal calculatedValue = new BigDecimal(getCalculatedValue());
		BigDecimal multiplicand = new BigDecimal(survey.getEvaluation().getCodeWeight());
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

	public Integer getObjectOriented() {
		return objectOriented;
	}

	public void setObjectOriented(Integer objectOriented) {
		this.objectOriented = objectOriented;
	}

	public Integer getUnderstandability() {
		return understandability;
	}

	public void setUnderstandability(Integer understandability) {
		this.understandability = understandability;
	}

	public Integer getExtensibility() {
		return extensibility;
	}

	public void setExtensibility(Integer extensibility) {
		this.extensibility = extensibility;
	}

	public Integer getTestability() {
		return testability;
	}

	public void setTestability(Integer testability) {
		this.testability = testability;
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
		result = prime * result
				+ ((extensibility == null) ? 0 : extensibility.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((objectOriented == null) ? 0 : objectOriented.hashCode());
		result = prime * result + ((survey == null) ? 0 : survey.hashCode());
		result = prime * result
				+ ((testability == null) ? 0 : testability.hashCode());
		result = prime
				* result
				+ ((understandability == null) ? 0 : understandability
						.hashCode());
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
		CodeDesign other = (CodeDesign) obj;
		if (extensibility == null) {
			if (other.extensibility != null)
				return false;
		} else if (!extensibility.equals(other.extensibility))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (objectOriented == null) {
			if (other.objectOriented != null)
				return false;
		} else if (!objectOriented.equals(other.objectOriented))
			return false;
		if (survey == null) {
			if (other.survey != null)
				return false;
		} else if (!survey.equals(other.survey))
			return false;
		if (testability == null) {
			if (other.testability != null)
				return false;
		} else if (!testability.equals(other.testability))
			return false;
		if (understandability == null) {
			if (other.understandability != null)
				return false;
		} else if (!understandability.equals(other.understandability))
			return false;
		return true;
	}
	
}
