package com.dmaximo.doc.model;

public class Endpoint {

	private int endpoint_id;
	private String endpoint_name;
	private String endpoint_method;

	public Endpoint() {
	}

	public Endpoint(int endpoint_id, String endpoint_name, String endpoint_method) {
		super();
		this.endpoint_id = endpoint_id;
		this.endpoint_name = endpoint_name;
		this.endpoint_method = endpoint_method;
	}

	public int getEndpoint_id() {
		return endpoint_id;
	}

	public void setEndpoint_id(int endpoint_id) {
		this.endpoint_id = endpoint_id;
	}

	public String getEndpoint_name() {
		return endpoint_name;
	}

	public void setEndpoint_name(String endpoint_name) {
		this.endpoint_name = endpoint_name;
	}

	public String getEndpoint_method() {
		return endpoint_method;
	}

	public void setEndpoint_method(String endpoint_method) {
		this.endpoint_method = endpoint_method;
	}

}
