package com.dmaximo.doc.dao;

import java.util.List;

import com.dmaximo.doc.model.Resource;

public interface ResourceDao {

	public List<Resource> getResources();

	public void saveResource(Resource resource);

	public Resource getResource(int resourceId);

	public void deleteResource(int resourceId);
	
}

