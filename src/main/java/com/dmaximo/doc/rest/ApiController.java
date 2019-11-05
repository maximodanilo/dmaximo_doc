package com.dmaximo.doc.rest;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dmaximo.doc.model.Api;
import com.dmaximo.doc.model.ResponseGeneric;
import com.dmaximo.doc.service.ApiService;

@RestController
@RequestMapping("/doc")
public class ApiController {

	@Autowired
	ApiService service;

	@GetMapping("/apis")
	public List<Api> getApis() {
		return service.getApis();

	}

	@GetMapping("/apis/{api_id}")
	public Api getApi(@PathVariable int api_id) {
		Api api = service.getApi(api_id);

		if (api == null) {
			throw new RuntimeException("Api ID " + api_id + " not found");
		}

		return api;

	}

	@DeleteMapping("/apis/{api_id}")
	public ResponseEntity<ResponseGeneric> deleteApi(@PathVariable int apiId) {
		Api api = service.getApi(apiId);

		if (api == null) {
			throw new RuntimeException("Api ID " + apiId + " not found");
		}

		service.deleteApi(apiId);

		ResponseGeneric response = new ResponseGeneric(HttpStatus.OK.value(), "Api " + apiId + " deleted",
				new Timestamp(System.currentTimeMillis()));

		return new ResponseEntity<ResponseGeneric>(response, HttpStatus.OK);

	}

	@PutMapping("/apis/{api_id}")
	public Api updateApi(@RequestBody Api api, @PathVariable int apiId) {

		Api api_db = service.getApi(apiId);

		if (api_db == null) {
			throw new RuntimeException("Api ID " + apiId + " not found");
		}

		api_db.apiCopyContent(api);

		return api_db;

	}

	@PostMapping
	public Api createApi(@RequestBody Api api) {

		api.setApiId(0);
		service.saveApi(api);

		return api;
	}

}
