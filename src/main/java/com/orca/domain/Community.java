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
@Table(name = "Community")
public class Community {

	@Id
	@Column(name = "id")
	@GeneratedValue
	private Integer id;
	@Range(min = 0, max = 5, errorCode="invalid.value")
	private Integer website;
	@Range(min = 0, max = 5, errorCode="invalid.value")
	private Integer mailingList;
	@Range(min = 0, max = 5, errorCode="invalid.value")
	private Integer bugTracker;
	@OneToOne  
	@JoinColumn(name = "surveyId")
	private Survey survey;

	public void populate() {
		setWebsite(3);
		setMailingList(3);
		setBugTracker(3);
	}
	
	public double getCalculatedValue() {
		BigDecimal site = new BigDecimal(website);
		BigDecimal mailList = new BigDecimal(mailingList);
		BigDecimal bugTrack = new BigDecimal(bugTracker);
		BigDecimal divisor = new BigDecimal(3);
		BigDecimal multiplicand = new BigDecimal(2);
		BigDecimal value = new BigDecimal("0");
		value = site.add(mailList).add(bugTrack);
		value = value.divide(divisor, 2, BigDecimal.ROUND_HALF_UP);
		value = value.multiply(multiplicand);
		return value.doubleValue();
	}
	
	public double getWeightedValue(Survey survey) {
		BigDecimal calculatedValue = new BigDecimal(getCalculatedValue());
		BigDecimal multiplicand = new BigDecimal(survey.getEvaluation().getCommunityWeight());
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

	public Integer getWebsite() {
		return website;
	}

	public void setWebsite(Integer website) {
		this.website = website;
	}

	public Integer getMailingList() {
		return mailingList;
	}

	public void setMailingList(Integer mailingList) {
		this.mailingList = mailingList;
	}

	public Integer getBugTracker() {
		return bugTracker;
	}

	public void setBugTracker(Integer bugTracker) {
		this.bugTracker = bugTracker;
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
		result = prime * result + bugTracker;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + mailingList;
		result = prime * result + ((survey == null) ? 0 : survey.hashCode());
		result = prime * result + website;
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
		Community other = (Community) obj;
		if (bugTracker != other.bugTracker)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (mailingList != other.mailingList)
			return false;
		if (survey == null) {
			if (other.survey != null)
				return false;
		} else if (!survey.equals(other.survey))
			return false;
		if (website != other.website)
			return false;
		return true;
	}

}
