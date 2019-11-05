package com.dmaximo.doc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dmaximo.doc.dao.ApiDao;
import com.dmaximo.doc.model.Api;

@Service
public class ApiServiceImpl implements ApiService {

	// need to inject Api dao
	@Autowired
	private ApiDao apiDao;

	@Override
	@Transactional
	public List<Api> getApis() {
		return apiDao.getApis();
	}

	@Override
	@Transactional
	public void saveApi(Api api) {

		apiDao.saveApi(api);
	}

	@Override
	@Transactional
	public Api getApi(int apiId) {

		return apiDao.getApi(apiId);
	}

	@Override
	@Transactional
	public void deleteApi(int apiId) {

		apiDao.deleteApi(apiId);
	}
}
