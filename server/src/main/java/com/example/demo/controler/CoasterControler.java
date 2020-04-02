package com.example.demo.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.Coaster;
import com.example.demo.model.Typ;
import com.example.demo.repos.CoasterRepository;
import com.example.demo.repos.DesignRepository;
import com.example.demo.repos.LocationRepository;
import com.example.demo.repos.StatusRepository;
import com.example.demo.repos.TypRepository;
import com.example.demo.service.RcdbScraper;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Controller
public class CoasterControler {
	@Autowired
	private CoasterRepository coasterRepository;
	@Autowired
	private TypRepository typRepository;
	@Autowired
	private DesignRepository designRepository;
	@Autowired
	private LocationRepository locationRepository;
	@Autowired
	private StatusRepository statusRepository;

	@Autowired
	private RcdbScraper rcdbScraper;

	
    @ApiOperation(value = "Parse rcdb.com and save to database.", notes = "", tags={ "rcdb", "coaster" })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successfull scraped and stored to db"),
        @ApiResponse(code = 403, message = "Forbidden") })
	@ResponseBody
	@GetMapping("/scrapeCoaster/{from}/{to}/toDb")
	public List<Coaster> scrapeCoasterToDb( //
			@ApiParam(value = "The id of the first page, to scrape.",required=true) @PathVariable("from") Integer from, //
			@ApiParam(value = "The id of the last page, to scrape.",required=true) @PathVariable("to") Integer to) {

		List<Coaster> scrape = rcdbScraper.scrape(from, to);

		locationRepository.saveAll(rcdbScraper.getLocations().values());
		typRepository.saveAll(rcdbScraper.getTyps().values());
		designRepository.saveAll(rcdbScraper.getDesigns().values());
		statusRepository.saveAll(rcdbScraper.getStatus().values());

		coasterRepository.saveAll(scrape);

		return scrape;
	}
	
    @ApiOperation(value = "Parse rcdb.com", notes = "", tags={ "rcdb", "coaster" })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successfull scraped"),
        @ApiResponse(code = 403, message = "Forbidden") })
	@ResponseBody
	@GetMapping("/scrapeCoaster/{from}/{to}")
	public List<Coaster> scrapeCoasterToDisplay( //
			@ApiParam(value = "The id of the first page, to scrape.",required=true) @PathVariable("from") Integer from, //
			@ApiParam(value = "The id of the last page, to scrape.",required=true) @PathVariable("to") Integer to) {

		List<Coaster> scrape = rcdbScraper.scrape(from, to);

		return scrape;
	}

	@ResponseBody
	@GetMapping("/coaster/static")
	public Coaster coasterStatic() {
		Coaster c = new Coaster();
		c.setId(43);
		c.setName("demo");
		c.setOpened("2019-01-01");

		Typ t = new Typ();
		t.setId(1);
		t.setName("Stahl");
		c.setTyp(t);
		return c;
	}

}
