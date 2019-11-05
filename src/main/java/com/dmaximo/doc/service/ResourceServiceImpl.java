package com.dmaximo.doc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dmaximo.doc.dao.ResourceDao;
import com.dmaximo.doc.model.Resource;

@Service
public class ResourceServiceImpl implements ResourceService {

	// need to inject Resource dao
	@Autowired
	private ResourceDao resourceDao;

	@Override
	@Transactional
	public List<Resource> getResources() {
		return resourceDao.getResources();
	}

	@Override
	@Transactional
	public void saveResource(Resource resource) {

		resourceDao.saveResource(resource);
	}

	@Override
	@Transactional
	public Resource getResource(int resourceId) {

		return resourceDao.getResource(resourceId);
	}

	@Override
	@Transactional
	public void deleteResource(int resourceId) {

		resourceDao.deleteResource(resourceId);
	}
}
