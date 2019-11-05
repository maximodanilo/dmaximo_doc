package com.dmaximo.doc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dmaximo.doc.model.Api;

@Repository
public class ApiDaoImpl implements ApiDao {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Api> getApis() {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create a query ... sort by apiname
		Query<Api> query = currentSession.createQuery("from Api order by api_name", Api.class);

		// execute query and get result list
		List<Api> apis = query.getResultList();

		// return the results
		return apis;
	}

	@Override
	public void saveApi(Api api) {

		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// save/upate the Api ... finally LOL
		currentSession.saveOrUpdate(api);

	}

	@Override
	public Api getApi(int apiId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// now retrieve/read from database using the primary key
		Api api = currentSession.get(Api.class, apiId);

		return api;
	}

	@Override
	public void deleteApi(int apiId) {

		Session currentSession = sessionFactory.getCurrentSession();

		Query<Api> query = currentSession.createQuery("delete from Api where api_id=:apiId", Api.class);
		query.setParameter("apiId", apiId);

		query.executeUpdate();
	}

}
