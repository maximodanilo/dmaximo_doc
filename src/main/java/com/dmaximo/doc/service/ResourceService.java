package com.dmaximo.doc.service;

import java.util.List;

import com.dmaximo.doc.model.Resource;

public interface ResourceService {

	public List<Resource> getResources();

	public void saveResource(Resource resource);

	public Resource getResource(int resourceId);

	public void deleteResource(int resourceId);

}
