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
@Table(name = "Documentation")
public class Documentation {
	
	@Id
	@GeneratedValue
	private Integer id;
	@Range(min = 0, max = 5, errorCode="invalid.value")
	private Integer userDocumentation;
	@Range(min = 0, max = 5, errorCode="invalid.value")
	private Integer developerDocumentation;
	@Range(min = 0, max = 5, errorCode="invalid.value")
	private Integer codeComments;
	@Range(min = 0, max = 5, errorCode="invalid.value")
	private Integer installationDocumentation;
	@Range(min = 0, max = 5, errorCode="invalid.value")
	private Integer administrationDocumentation;
	@OneToOne  
	@JoinColumn(name = "surveyId")
	private Survey survey;

	public void populate() {
		setUserDocumentation(3);
		setDeveloperDocumentation(3);
		setCodeComments(3);
		setInstallationDocumentation(3);
		setAdministrationDocumentation(3);
	}
	
	public double getCalculatedValue(){
			BigDecimal userDoc = new BigDecimal(userDocumentation);
			BigDecimal developerDoc = new BigDecimal(developerDocumentation);
			BigDecimal codeComment = new BigDecimal(codeComments);
			BigDecimal installationDoc = new BigDecimal(installationDocumentation);
			BigDecimal administrationDoc = new BigDecimal(administrationDocumentation);
			BigDecimal divisor = new BigDecimal(5);
			BigDecimal multiplicand = new BigDecimal(2);
			BigDecimal value = new BigDecimal("0");
			value = userDoc.add(developerDoc).add(codeComment).add(installationDoc).add(administrationDoc);
			value = value.divide(divisor, 2, BigDecimal.ROUND_HALF_UP);
			value = value.multiply(multiplicand);
			return value.doubleValue();
	}

	public double getWeightedValue(Survey survey) {
		BigDecimal calculatedValue = new BigDecimal(getCalculatedValue());
		BigDecimal multiplicand = new BigDecimal(survey.getEvaluation().getDocumentationWeight());
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

	public Integer getUserDocumentation() {
		return userDocumentation;
	}

	public void setUserDocumentation(Integer userDocumentation) {
		this.userDocumentation = userDocumentation;
	}

	public Integer getDeveloperDocumentation() {
		return developerDocumentation;
	}

	public void setDeveloperDocumentation(Integer developerDocumentation) {
		this.developerDocumentation = developerDocumentation;
	}

	public Integer getCodeComments() {
		return codeComments;
	}

	public void setCodeComments(Integer codeComments) {
		this.codeComments = codeComments;
	}

	public Integer getInstallationDocumentation() {
		return installationDocumentation;
	}

	public void setInstallationDocumentation(Integer installationDocumentation) {
		this.installationDocumentation = installationDocumentation;
	}

	public Integer getAdministrationDocumentation() {
		return administrationDocumentation;
	}

	public void setAdministrationDocumentation(Integer administrationDocumentation) {
		this.administrationDocumentation = administrationDocumentation;
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
		result = prime * result + administrationDocumentation;
		result = prime * result + codeComments;
		result = prime * result + developerDocumentation;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + installationDocumentation;
		result = prime * result + ((survey == null) ? 0 : survey.hashCode());
		result = prime * result + userDocumentation;
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
		Documentation other = (Documentation) obj;
		if (administrationDocumentation != other.administrationDocumentation)
			return false;
		if (codeComments != other.codeComments)
			return false;
		if (developerDocumentation != other.developerDocumentation)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (installationDocumentation != other.installationDocumentation)
			return false;
		if (survey == null) {
			if (other.survey != null)
				return false;
		} else if (!survey.equals(other.survey))
			return false;
		if (userDocumentation != other.userDocumentation)
			return false;
		return true;
	}

}
