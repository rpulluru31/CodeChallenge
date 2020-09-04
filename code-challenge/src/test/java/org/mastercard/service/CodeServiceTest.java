package org.mastercard.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CodeServiceTest {

	@Autowired
	private TestRestTemplate testRestTemplate;
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testFindRouteBetweenBostonAndNewark() {
		 Map<String, String> params = new HashMap<>();
	        params.put("origin", "Boston");
	        params.put("destination", "Newark");

	        String body = testRestTemplate.getForObject("/connected?origin={origin}&destination={destination}", String.class, params);
	        Assertions.assertEquals("YES", body);
	}
	
	@Test
	void testFindRouteBetweenBostonAndPhiladelphia() {
		 Map<String, String> params = new HashMap<>();
	        params.put("origin", "Boston");
	        params.put("destination", "Philadelphia");

	        String body = testRestTemplate.getForObject("/connected?origin={origin}&destination={destination}", String.class, params);
	        Assertions.assertEquals("YES", body);
	}
	
	@Test
	void testFindRouteBetweenPhiladelphiaAndAlbany() {
		 Map<String, String> params = new HashMap<>();
	        params.put("origin", "Philadelphia");
	        params.put("destination", "Albany");

	        String body = testRestTemplate.getForObject("/connected?origin={origin}&destination={destination}", String.class, params);
	        Assertions.assertEquals("NO", body);
	}

}
