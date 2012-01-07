package com.orca.domain;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springmodules.validation.bean.conf.loader.annotation.handler.NotNull;
import org.springmodules.validation.bean.conf.loader.annotation.handler.Range;

@Entity
@Table (name = "Evaluation")
public class Evaluation {

	@Id
	@GeneratedValue
	@Column (name = "id")
	private Integer id;
	@Column(name = "number")
	@NotNull
	private long number;
	@Column(name = "name")
	@NotNull
	private String name;
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="evaluation")
	private List <Survey> surveyList;
	private Integer functionalityWeight;
	@Range(min = 1, max = 100)
	private Integer licenseWeight;
	@Range(min = 1, max = 100)
	private Integer codeWeight;
	@Range(min = 1, max = 100)	
	private Integer velocityWeight;
	@Range(min = 1, max = 100)	
	private Integer pedigreeWeight;
	@Range(min = 1, max = 100)	
	private Integer communityWeight;
	@Range(min = 1, max = 100)	
	private Integer marketWeight;
	@Range(min = 1, max = 100)	
	private Integer documentationWeight;
	@Range(min = 1, max = 100)	
	private Integer supportWeight;
	@ManyToOne
	@JoinColumn(name = "userid")
	private User user;
	
	public void populate() {
		setName("Sample Evaluation");
		setFunctionalityWeight(100);
		setLicenseWeight(100);
		setCodeWeight(100);
		setVelocityWeight(100);
		setPedigreeWeight(100);
		setCommunityWeight(100);
		setMarketWeight(100);
		setDocumentationWeight(100);
		setSupportWeight(100);
	}

	public void addSurvey(Survey survey) {
		if (surveyList == null) {
			surveyList = new ArrayList<Survey>();
		}
		surveyList.add(survey);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public long getNumber() {
		return number;
	}

	public void setNumber(long number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Survey> getSurveyList() {
		return surveyList;
	}

	public void setSurveyList(List<Survey> surveyList) {
		this.surveyList = surveyList;
	}

	public Integer getFunctionalityWeight() {
		return functionalityWeight;
	}

	public void setFunctionalityWeight(Integer functionalityWeight) {
		this.functionalityWeight = functionalityWeight;
	}

	public Integer getLicenseWeight() {
		return licenseWeight;
	}

	public void setLicenseWeight(Integer licenseWeight) {
		this.licenseWeight = licenseWeight;
	}

	public Integer getCodeWeight() {
		return codeWeight;
	}

	public void setCodeWeight(Integer codeWeight) {
		this.codeWeight = codeWeight;
	}

	public Integer getVelocityWeight() {
		return velocityWeight;
	}

	public void setVelocityWeight(Integer velocityWeight) {
		this.velocityWeight = velocityWeight;
	}

	public Integer getPedigreeWeight() {
		return pedigreeWeight;
	}

	public void setPedigreeWeight(Integer pedigreeWeight) {
		this.pedigreeWeight = pedigreeWeight;
	}

	public Integer getCommunityWeight() {
		return communityWeight;
	}

	public void setCommunityWeight(Integer communityWeight) {
		this.communityWeight = communityWeight;
	}

	public Integer getMarketWeight() {
		return marketWeight;
	}

	public void setMarketWeight(Integer marketWeight) {
		this.marketWeight = marketWeight;
	}

	public Integer getDocumentationWeight() {
		return documentationWeight;
	}

	public void setDocumentationWeight(Integer documentationWeight) {
		this.documentationWeight = documentationWeight;
	}

	public Integer getSupportWeight() {
		return supportWeight;
	}

	public void setSupportWeight(Integer supportWeight) {
		this.supportWeight = supportWeight;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((codeWeight == null) ? 0 : codeWeight.hashCode());
		result = prime * result
				+ ((communityWeight == null) ? 0 : communityWeight.hashCode());
		result = prime
				* result
				+ ((documentationWeight == null) ? 0 : documentationWeight
						.hashCode());
		result = prime
				* result
				+ ((functionalityWeight == null) ? 0 : functionalityWeight
						.hashCode());
		result = prime * result
				+ ((licenseWeight == null) ? 0 : licenseWeight.hashCode());
		result = prime * result
				+ ((marketWeight == null) ? 0 : marketWeight.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + (int) (number ^ (number >>> 32));
		result = prime * result
				+ ((pedigreeWeight == null) ? 0 : pedigreeWeight.hashCode());
		result = prime * result
				+ ((supportWeight == null) ? 0 : supportWeight.hashCode());
		result = prime * result
				+ ((surveyList == null) ? 0 : surveyList.hashCode());
		result = prime * result
				+ ((velocityWeight == null) ? 0 : velocityWeight.hashCode());
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
		Evaluation other = (Evaluation) obj;
		if (codeWeight == null) {
			if (other.codeWeight != null)
				return false;
		} else if (!codeWeight.equals(other.codeWeight))
			return false;
		if (communityWeight == null) {
			if (other.communityWeight != null)
				return false;
		} else if (!communityWeight.equals(other.communityWeight))
			return false;
		if (documentationWeight == null) {
			if (other.documentationWeight != null)
				return false;
		} else if (!documentationWeight.equals(other.documentationWeight))
			return false;
		if (functionalityWeight == null) {
			if (other.functionalityWeight != null)
				return false;
		} else if (!functionalityWeight.equals(other.functionalityWeight))
			return false;
		if (licenseWeight == null) {
			if (other.licenseWeight != null)
				return false;
		} else if (!licenseWeight.equals(other.licenseWeight))
			return false;
		if (marketWeight == null) {
			if (other.marketWeight != null)
				return false;
		} else if (!marketWeight.equals(other.marketWeight))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (number != other.number)
			return false;
		if (pedigreeWeight == null) {
			if (other.pedigreeWeight != null)
				return false;
		} else if (!pedigreeWeight.equals(other.pedigreeWeight))
			return false;
		if (supportWeight == null) {
			if (other.supportWeight != null)
				return false;
		} else if (!supportWeight.equals(other.supportWeight))
			return false;
		if (surveyList == null) {
			if (other.surveyList != null)
				return false;
		} else if (!surveyList.equals(other.surveyList))
			return false;
		if (velocityWeight == null) {
			if (other.velocityWeight != null)
				return false;
		} else if (!velocityWeight.equals(other.velocityWeight))
			return false;
		return true;
	}


}
