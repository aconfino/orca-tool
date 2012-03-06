package com.orca.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.orca.domain.Evaluation;

@Transactional
@Repository
public class EvaluationDAOImpl implements EvaluationDAO{
	
	private HibernateTemplate template;
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		template = new HibernateTemplate(sessionFactory);
	}

	@Transactional()
	@SuppressWarnings("unchecked")
	public Evaluation getEvaluationByNumber(Long number) {
		Evaluation evaluation= null;
		List <Evaluation> list = template.find("from Evaluation where number = ? ", number);
		if (list.size()>0){
			evaluation = list.get(0);
		}
		return evaluation;
	}
	
	@Transactional()
	@SuppressWarnings("unchecked")
	public Evaluation getEvaluationById(Integer evaluationId) {
		Evaluation evaluation= null;
		List <Evaluation> list = template.find("from Evaluation where id = ? ", evaluationId);
		if (list.size()>0){
			evaluation = list.get(0);
		}
		return evaluation;
	}

	@Transactional(readOnly = false)
	public void saveEvaluation(Evaluation evaluation) {
		template.saveOrUpdate(evaluation);
	}

	@Transactional(readOnly = false)
	public void removeEvaluation(Evaluation evaluation) {
		template.delete(evaluation);
	}
	
}
