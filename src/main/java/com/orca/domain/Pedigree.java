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
@Table( name = "Pedigree")
public class Pedigree {

	@Id
	@GeneratedValue
	private Integer id;
	@Range(min = 0, max = 5, errorCode="invalid.value")
	private Integer author;
	@Range(min = 0, max = 5, errorCode="invalid.value")
	private Integer groupSponsor;
	@Range(min = 0, max = 5, errorCode="invalid.value")
	private Integer derived;
	@OneToOne  
	@JoinColumn(name = "surveyId")
	private Survey survey;

	public void populate() {
		setAuthor(3);
		setGroupSponsor(3);
		setDerived(3);
	}
	
	public double getCalculatedValue(){
		BigDecimal auth = new BigDecimal(author);
		BigDecimal group = new BigDecimal(groupSponsor);
		BigDecimal derive = new BigDecimal(derived);
		BigDecimal divisor = new BigDecimal(3);
		BigDecimal multiplicand = new BigDecimal(2);
		BigDecimal value = new BigDecimal("0");
		value = auth.add(group).add(derive);
		value = value.divide(divisor, 2, BigDecimal.ROUND_HALF_UP);
		value = value.multiply(multiplicand);
		return value.doubleValue();
	}

	public double getWeightedValue(Survey survey) {
		BigDecimal calculatedValue = new BigDecimal(getCalculatedValue());
		BigDecimal multiplicand = new BigDecimal(survey.getEvaluation().getPedigreeWeight());
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

	public Integer getAuthor() {
		return author;
	}

	public void setAuthor(Integer author) {
		this.author = author;
	}

	public Integer getGroupSponsor() {
		return groupSponsor;
	}

	public void setGroupSponsor(Integer groupSponsor) {
		this.groupSponsor = groupSponsor;
	}

	public Integer getDerived() {
		return derived;
	}

	public void setDerived(Integer derived) {
		this.derived = derived;
	}

	public Survey getSurvey() {
		return survey;
	}

	public void setSurvey(Survey survey) {
		this.survey = survey;
	}

}
