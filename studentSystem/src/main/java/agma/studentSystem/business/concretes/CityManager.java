package agma.studentSystem.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import agma.studentSystem.business.abstracts.CityService;
import agma.studentSystem.dataAccess.abstracts.CityRepository;
import agma.studentSystem.entities.concretes.City;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CityManager implements CityService{
	
	private CityRepository cityRepository;

	@Override
	public List<City> getAll() {
		return cityRepository.findAll();
	}

}
