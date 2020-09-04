package org.mastercard.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
public class CodeService {

	private static final Logger LOG = LoggerFactory.getLogger(CodeService.class);

	@Value("${input.file}")
	private String inputFile;

	public String findRoute(String origin, String destination) throws IOException {

		String roadExists = "no";
		Path path = Paths.get(inputFile);
		List<String> originCities = null;
		List<String> destinationCities = null;
		Stream<String[]> cities = null;

		try {
			
			cities = Files.lines(path).map(line -> line.split(",")).filter(city -> Arrays.asList(city).contains(origin));
			
			originCities = cities.flatMap((p) -> Arrays.asList(p).stream()).distinct().collect(Collectors.toList());
			LOG.info("ORIGIN LIST:");
			originCities.stream().forEach(e -> LOG.info(e));
			
				
		} catch (IOException e) {			
			throw new IOException(e);
			
		}

		try {
			
			cities = Files.lines(path).map(line -> line.split(",")).filter(city -> Arrays.asList(city).contains(destination));
			destinationCities = cities.flatMap((p) -> Arrays.asList(p).stream()).distinct().collect(Collectors.toList());
			LOG.info("DESTINATION CITIES:");
			destinationCities.stream().forEach(e -> LOG.info(e));			

		} catch (IOException e) {
			throw new IOException(e);
		}

		final List<String>finalDestinationCities = destinationCities;
		roadExists = originCities.stream().flatMap(x -> finalDestinationCities.stream().filter(y -> x.equals(y)).limit(1)).findFirst().isPresent()?"YES":"NO";
		LOG.info("Road Route exists between Specified Cities: {}", roadExists);
		return roadExists;

	}

}
