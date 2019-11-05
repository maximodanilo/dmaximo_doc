package com.dmaximo.doc.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "resource")
public class Resource {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "resource_id")
	private int resourceId;

	@Column(name = "resource_name")
	private String resourceName;

	@Column(name = "resource_desc1")
	private String resourceDesc1;

	@Column(name = "resource_desc2")
	private String resourceDesc2;

	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinColumn(name = "api_id")
	private Api api;

	public Resource() {
	}

	public Resource(int resource_id, String resource_name, String resource_desc1, String resource_desc2) {
		super();
		this.resourceId = resource_id;
		this.resourceName = resource_name;
		this.resourceDesc1 = resource_desc1;
		this.resourceDesc2 = resource_desc2;
	}

	public int getResourceId() {
		return resourceId;
	}

	public void setResourceId(int resourceId) {
		this.resourceId = resourceId;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public String getResourceDesc1() {
		return resourceDesc1;
	}

	public void setResourceDesc1(String resourceDesc1) {
		this.resourceDesc1 = resourceDesc1;
	}

	public String getResourceDesc2() {
		return resourceDesc2;
	}

	public void setResourceDesc2(String resourceDesc2) {
		this.resourceDesc2 = resourceDesc2;
	}

	public Api getApi() {
		return api;
	}

	public void setApi(Api api) {
		this.api = api;
	}

	public void resourceCopyContent(Resource resource) {
		this.resourceName = resource.resourceName != null ? resource.resourceName : this.resourceName;
		this.resourceDesc1 = resource.resourceDesc1 != null ? resource.resourceDesc1 : this.resourceDesc1;
		this.resourceDesc2 = resource.resourceDesc2 != null ? resource.resourceDesc2 : this.resourceDesc2;
	}

}
