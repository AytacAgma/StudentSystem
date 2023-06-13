package agma.studentSystem.webApi.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import agma.studentSystem.business.abstracts.TownService;
import agma.studentSystem.entities.concretes.Town;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/towns")
@AllArgsConstructor
@CrossOrigin
public class TownsController {
	private TownService townService;
	
	@GetMapping("/{city_id}")
	public List<Town> getByCity(@PathVariable Integer city_id) {
		return this.townService.getByCityId(city_id);
	}
}
