package com.orca.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.orca.domain.Survey;

@Transactional
@Repository
public class SurveyDAOImpl implements SurveyDAO{
	
	private HibernateTemplate template;
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		template = new HibernateTemplate(sessionFactory);
	}

	@Transactional(readOnly = false)
	public void saveSurvey(Survey survey) {
		template.saveOrUpdate(survey);
	}
	
	@Transactional(readOnly = false)
	public void removeSurvey(Survey survey) {
		template.delete(survey);
	}

	@Transactional()
	@SuppressWarnings("unchecked")
	public Survey getSurvey(Integer surveyId) {
		List <Survey> list = template.find("from Survey where id = ? ", surveyId);
		Survey survey = null;
		if (list.size()>0){
			survey = (Survey) list.get(0);
		}
		return survey;
	}

}
