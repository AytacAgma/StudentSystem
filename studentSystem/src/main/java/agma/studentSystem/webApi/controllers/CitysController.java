package agma.studentSystem.webApi.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import agma.studentSystem.business.abstracts.CityService;
import agma.studentSystem.entities.concretes.City;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/cities")
@AllArgsConstructor
@CrossOrigin
public class CitysController {
	private CityService cityService;
	
	@GetMapping()
	public List<City> getAll() {
		return this.cityService.getAll();
	}

}
