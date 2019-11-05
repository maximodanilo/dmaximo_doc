package com.dmaximo.doc.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

public class Api {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "api_id")
	private int apiId;

	@Column(name = "api_name")
	private String apiName;

	@Column(name = "api_base_url")
	private String apiBaseUrl;

	@OneToMany(mappedBy = "resource", cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REFRESH })
	private List<Resource> resources;

	public Api() {
	}

	public Api(int apiId, String apiName, String apiBaseUrl) {
		super();
		this.apiId = apiId;
		this.apiName = apiName;
		this.apiBaseUrl = apiBaseUrl;
	}

	public int getApi_id() {
		return apiId;
	}

	public void setApiId(int apiId) {
		this.apiId = apiId;
	}

	public String getApiName() {
		return apiName;
	}

	public void setApiName(String api_name) {
		this.apiName = api_name;
	}

	public String getApiBaseUrl() {
		return apiBaseUrl;
	}

	public void setApiBaseUrl(String apiBaseUrl) {
		this.apiBaseUrl = apiBaseUrl;
	}

	public void add(Resource resource) {
		if (resources == null) {
			resources = new ArrayList<>();
		}
		resources.add(resource);

		resource.setApi(this);
	}

	public void apiCopyContent(Api api) {
		this.apiName = api.apiName != null ? api.apiName : this.apiName;
		this.apiBaseUrl = api.apiBaseUrl != null ? api.apiBaseUrl : this.apiBaseUrl;
	}

}
