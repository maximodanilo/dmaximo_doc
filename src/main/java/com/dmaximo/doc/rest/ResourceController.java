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

import com.dmaximo.doc.model.Resource;
import com.dmaximo.doc.model.ResponseGeneric;
import com.dmaximo.doc.service.ResourceService;

@RestController
@RequestMapping("/doc")
public class ResourceController {

	@Autowired
	ResourceService service;

	@GetMapping("/resources")
	public List<Resource> getResources() {
		return service.getResources();

	}

	@GetMapping("/resources/{resource_id}")
	public Resource getResource(@PathVariable int resource_id) {
		Resource resource = service.getResource(resource_id);

		if (resource == null) {
			throw new RuntimeException("Resource ID " + resource_id + " not found");
		}

		return resource;

	}

	@DeleteMapping("/resources/{resource_id}")
	public ResponseEntity<ResponseGeneric> deleteResource(@PathVariable int resourceId) {
		Resource resource = service.getResource(resourceId);

		if (resource == null) {
			throw new RuntimeException("Resource ID " + resourceId + " not found");
		}

		service.deleteResource(resourceId);

		ResponseGeneric response = new ResponseGeneric(HttpStatus.OK.value(), "Resource " + resourceId + " deleted",
				new Timestamp(System.currentTimeMillis()));

		return new ResponseEntity<ResponseGeneric>(response, HttpStatus.OK);

	}

	@PutMapping("/resources/{resource_id}")
	public Resource updateResource(@RequestBody Resource resource, @PathVariable int resourceId) {

		Resource resource_db = service.getResource(resourceId);

		if (resource_db == null) {
			throw new RuntimeException("Resource ID " + resourceId + " not found");
		}

		resource_db.resourceCopyContent(resource);

		return resource_db;

	}

	@PostMapping
	public Resource createResource(@RequestBody Resource resource) {

		resource.setResourceId(0);
		service.saveResource(resource);

		return resource;
	}

}
