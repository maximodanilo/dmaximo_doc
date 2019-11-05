package com.dmaximo.doc.service;

import java.util.List;

import com.dmaximo.doc.model.Api;

public interface ApiService {

	public List<Api> getApis();

	public void saveApi(Api api);

	public Api getApi(int apiId);

	public void deleteApi(int apiId);

}
