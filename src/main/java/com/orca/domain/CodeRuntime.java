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
@Table(name = "CodeRuntime")
public class CodeRuntime {

	@Id
	@Column(name = "id")
	@GeneratedValue
	private Integer id;
	@Range(min = 0, max = 5, errorCode="invalid.value")
	@Column(name = "cpuThreshhold")
	private Integer cpuThreshhold;
	@Range(min = 0, max = 5, errorCode="invalid.value")
	@Column(name = "memoryThreshhold")
	private Integer memoryThreshhold;
	@Range(min = 0, max = 5, errorCode="invalid.value")
	@Column(name = "IOThreshhold")
	private Integer IOThreshhold;
	@OneToOne  
	@JoinColumn(name = "surveyId")
	private Survey survey;
	
	public void populate(){
		setCpuThreshhold(3);
		setMemoryThreshhold(3);
		setIOThreshhold(3);
	}
	
	public double getCalculatedValue(){
			BigDecimal cpu = new BigDecimal(cpuThreshhold);
			BigDecimal memoryThresh = new BigDecimal(memoryThreshhold);
			BigDecimal ioThresh = new BigDecimal(IOThreshhold);
			BigDecimal divisor = new BigDecimal(3);
			BigDecimal multiplicand = new BigDecimal(2);
			BigDecimal value = new BigDecimal("0");
			value = cpu.add(memoryThresh).add(ioThresh);
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

	public Integer getCpuThreshhold() {
		return cpuThreshhold;
	}

	public void setCpuThreshhold(Integer cpuThreshhold) {
		this.cpuThreshhold = cpuThreshhold;
	}

	public Integer getMemoryThreshhold() {
		return memoryThreshhold;
	}

	public void setMemoryThreshhold(Integer memoryThreshhold) {
		this.memoryThreshhold = memoryThreshhold;
	}

	public Integer getIOThreshhold() {
		return IOThreshhold;
	}

	public void setIOThreshhold(Integer iOThreshhold) {
		IOThreshhold = iOThreshhold;
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
		result = prime * result + IOThreshhold;
		result = prime * result + cpuThreshhold;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + memoryThreshhold;
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
		CodeRuntime other = (CodeRuntime) obj;
		if (IOThreshhold != other.IOThreshhold)
			return false;
		if (cpuThreshhold != other.cpuThreshhold)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (memoryThreshhold != other.memoryThreshhold)
			return false;
		if (survey == null) {
			if (other.survey != null)
				return false;
		} else if (!survey.equals(other.survey))
			return false;
		return true;
	}
	
}
