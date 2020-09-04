package org.mastercard.controller;

import java.io.IOException;

import org.mastercard.service.CodeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class CodeController {

	private static final Logger LOG = LoggerFactory.getLogger(CodeController.class);
	
	@Autowired
	private CodeService codeService;

	@GetMapping(value = "/connected",produces = "text/plain")
	public String user(@RequestParam(defaultValue = "city1") String origin,	@RequestParam(defaultValue = "city2") String destination) {

		String result="no";

		try {
			result = codeService.findRoute(origin, destination);
		} catch (IOException e) {
			LOG.error(e.getMessage());
		}

		return result;
	}

	@RequestMapping("/")
	public String index() {
		return "Please use the end point - http://localhost:8080/connected, input parameters - Origin and Destination cities";
	}

}
