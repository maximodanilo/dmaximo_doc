package com.dmaximo.doc.dao;

import java.util.List;

import com.dmaximo.doc.model.Api;

public interface ApiDao {

	public List<Api> getApis();

	public void saveApi(Api api);

	public Api getApi(int apiId);

	public void deleteApi(int apiId);
	
}

