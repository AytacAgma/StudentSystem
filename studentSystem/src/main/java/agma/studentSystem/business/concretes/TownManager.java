package agma.studentSystem.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import agma.studentSystem.business.abstracts.TownService;
import agma.studentSystem.dataAccess.abstracts.TownRepository;
import agma.studentSystem.entities.concretes.Town;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TownManager implements TownService{
	private TownRepository townRepository;

	@Override
	public List<Town> getByCityId(Integer city_id) {
		return townRepository.findByCityId(city_id);
	}

}
