package com.dmaximo.doc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dmaximo.doc.model.Resource;

@Repository
public class ResourceDaoImpl implements ResourceDao {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Resource> getResources() {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create a query ... sort by last name
		Query<Resource> theQuery = currentSession.createQuery("from Resource order by lastName", Resource.class);

		// execute query and get result list
		List<Resource> resources = theQuery.getResultList();

		// return the results
		return resources;
	}

	@Override
	public void saveResource(Resource resource) {

		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// save/upate the resource ... finally LOL
		currentSession.saveOrUpdate(resource);

	}

	@Override
	public Resource getResource(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// now retrieve/read from database using the primary key
		Resource resource = currentSession.get(Resource.class, theId);

		return resource;
	}

	@Override
	public void deleteResource(int resourceId) {

		Session currentSession = sessionFactory.getCurrentSession();

		Query<Resource> theQuery = currentSession.createQuery("delete from Resource where resource_id=:resourceId",
				Resource.class);
		theQuery.setParameter("resourceId", resourceId);

		theQuery.executeUpdate();
	}

}
