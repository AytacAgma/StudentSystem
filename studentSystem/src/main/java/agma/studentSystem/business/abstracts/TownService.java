package agma.studentSystem.business.abstracts;

import java.util.List;

import agma.studentSystem.entities.concretes.Town;

public interface TownService {
	List<Town> getByCityId(Integer city_id);
}
