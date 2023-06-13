package agma.studentSystem.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import agma.studentSystem.entities.concretes.Town;

public interface TownRepository extends JpaRepository<Town, Integer> {
	List<Town> findByCityId(Integer city_id);
}
