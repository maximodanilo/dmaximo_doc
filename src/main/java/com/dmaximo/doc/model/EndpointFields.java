package com.dmaximo.doc.model;

public class EndpointFields {

	private int endpoint_id;
	private String field_name;
	private String field_datatype;
	private String field_required;
	private String field_desc;

	public EndpointFields() {
	}

	public EndpointFields(int endpoint_id, String field_name, String field_datatype, String field_required,
			String field_desc) {
		super();
		this.endpoint_id = endpoint_id;
		this.field_name = field_name;
		this.field_datatype = field_datatype;
		this.field_required = field_required;
		this.field_desc = field_desc;
	}

	public int getEndpoint_id() {
		return endpoint_id;
	}

	public void setEndpoint_id(int endpoint_id) {
		this.endpoint_id = endpoint_id;
	}

	public String getField_name() {
		return field_name;
	}

	public void setField_name(String field_name) {
		this.field_name = field_name;
	}

	public String getField_datatype() {
		return field_datatype;
	}

	public void setField_datatype(String field_datatype) {
		this.field_datatype = field_datatype;
	}

	public String getField_required() {
		return field_required;
	}

	public void setField_required(String field_required) {
		this.field_required = field_required;
	}

	public String getField_desc() {
		return field_desc;
	}

	public void setField_desc(String field_desc) {
		this.field_desc = field_desc;
	}

}
