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
@Table(name = "CodeStatic")
public class CodeStatic {

	@Id
	@GeneratedValue
	private Integer id;
	@Range(min = 0, max = 5, errorCode = "invalid.value")
	private Integer cyclomaticComplexity;
	@Range(min = 0, max = 5, errorCode = "invalid.value")
	private Integer methodCount;
	@Range(min = 0, max = 5, errorCode = "invalid.value")
	private Integer dependencyCycles;
	@OneToOne
	@JoinColumn(name = "surveyId")
	private Survey survey;

	public void populate() {
		setCyclomaticComplexity(3);
		setMethodCount(3);
		setDependencyCycles(3);
	}

	public double getCalculatedValue() {
		BigDecimal cycloComplex = new BigDecimal(cyclomaticComplexity);
		BigDecimal methodCnt = new BigDecimal(methodCount);
		BigDecimal dependCycles = new BigDecimal(dependencyCycles);
		BigDecimal divisor = new BigDecimal(3);
		BigDecimal multiplicand = new BigDecimal(2);
		BigDecimal value = new BigDecimal("0");
		value = cycloComplex.add(methodCnt).add(dependCycles);
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

	public Integer getCyclomaticComplexity() {
		return cyclomaticComplexity;
	}

	public void setCyclomaticComplexity(Integer cyclomaticComplexity) {
		this.cyclomaticComplexity = cyclomaticComplexity;
	}

	public Integer getMethodCount() {
		return methodCount;
	}

	public void setMethodCount(Integer methodCount) {
		this.methodCount = methodCount;
	}

	public Integer getDependencyCycles() {
		return dependencyCycles;
	}

	public void setDependencyCycles(Integer dependencyCycles) {
		this.dependencyCycles = dependencyCycles;
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
		result = prime * result + cyclomaticComplexity;
		result = prime * result + dependencyCycles;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + methodCount;
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
		CodeStatic other = (CodeStatic) obj;
		if (cyclomaticComplexity != other.cyclomaticComplexity)
			return false;
		if (dependencyCycles != other.dependencyCycles)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (methodCount != other.methodCount)
			return false;
		if (survey == null) {
			if (other.survey != null)
				return false;
		} else if (!survey.equals(other.survey))
			return false;
		return true;
	}

}
