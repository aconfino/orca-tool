package com.orca.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Survey")
public class Survey {

	@Id
	@Column(name = "id")
	@GeneratedValue
	private Integer id;
	private String surveyName;
	private String comments;
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "survey")
	private CodeDesign codeDesign;
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "survey")
	private CodeRuntime codeRuntime;
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "survey")
	private CodeStatic codeStatic;
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "survey")
	private Community community;
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "survey")
	private Documentation documentation;
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "survey")
	private License license;
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "survey")
	private MarketPenetration marketPenetration;
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "survey")
	private Pedigree pedigree;
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "survey")
	private Support support;
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "survey")
	private Velocity velocity;
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "survey")
	private Functionality functionality;
	@ManyToOne
	@JoinColumn(name = "evaluationId")
	private Evaluation evaluation;
	private double score;
	
	public double getScore(){
		return (codeDesign.getWeightedValue(this) 
				+ codeRuntime.getWeightedValue(this)
				+ codeStatic.getWeightedValue(this)
				+ community.getWeightedValue(this)
				+ documentation.getWeightedValue(this)
				+ license.getWeightedValue(this)
				+ marketPenetration.getWeightedValue(this)
				+ pedigree.getWeightedValue(this)
				+ support.getWeightedValue(this)
				+ velocity.getWeightedValue(this)
				+ functionality.getWeightedValue(this));
	}
	
	public void setScore(double score) {
		this.score = score;
	}



	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSurveyName() {
		return surveyName;
	}
	public void setSurveyName(String surveyName) {
		this.surveyName = surveyName;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public CodeDesign getCodeDesign() {
		return codeDesign;
	}
	public void setCodeDesign(CodeDesign codeDesign) {
		this.codeDesign = codeDesign;
	}
	public CodeRuntime getCodeRuntime() {
		return codeRuntime;
	}
	public void setCodeRuntime(CodeRuntime codeRuntime) {
		this.codeRuntime = codeRuntime;
	}
	public CodeStatic getCodeStatic() {
		return codeStatic;
	}
	public void setCodeStatic(CodeStatic codeStatic) {
		this.codeStatic = codeStatic;
	}
	public Community getCommunity() {
		return community;
	}
	public void setCommunity(Community community) {
		this.community = community;
	}
	public Documentation getDocumentation() {
		return documentation;
	}
	public void setDocumentation(Documentation documentation) {
		this.documentation = documentation;
	}
	public License getLicense() {
		return license;
	}
	public void setLicense(License license) {
		this.license = license;
	}

	public MarketPenetration getMarketPenetration() {
		return marketPenetration;
	}
	public void setMarketPenetration(MarketPenetration marketPenetration) {
		this.marketPenetration = marketPenetration;
	}
	public Pedigree getPedigree() {
		return pedigree;
	}
	public void setPedigree(Pedigree pedigree) {
		this.pedigree = pedigree;
	}
	public Support getSupport() {
		return support;
	}
	public void setSupport(Support support) {
		this.support = support;
	}
	public Velocity getVelocity() {
		return velocity;
	}
	public void setVelocity(Velocity velocity) {
		this.velocity = velocity;
	}
	public Functionality getFunctionality() {
		return functionality;
	}
	public void setFunctionality(Functionality functionality) {
		this.functionality = functionality;
	}
	public Evaluation getEvaluation() {
		return evaluation;
	}
	public void setEvaluation(Evaluation evaluation) {
		this.evaluation = evaluation;
	}
	
}
