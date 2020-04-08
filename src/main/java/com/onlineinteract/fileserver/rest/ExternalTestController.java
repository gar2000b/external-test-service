package com.onlineinteract.fileserver.rest;

import java.util.Iterator;
import java.util.Map;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
@EnableAutoConfiguration
public class ExternalTestController {

	@RequestMapping(method = RequestMethod.GET, produces = "application/json", value = "/fetchGoogle")
	@ResponseBody
	public ResponseEntity<String> fetchGoogle(@RequestHeader HttpHeaders incomingHeaders) {
		System.out.println("\nFetching \"https://www.google.com\"");
		
		System.out.println("Headers: ");
	    Iterator it = incomingHeaders.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry pair = (Map.Entry)it.next();
	        System.out.println(pair.getKey() + " = " + pair.getValue());
	    }

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.getForEntity("https://www.google.com", String.class);
		
		return new ResponseEntity<>(response.getBody(), response.getStatusCode());
	}
}
