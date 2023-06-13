package agma.studentSystem.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import agma.studentSystem.entities.concretes.City;

public interface CityRepository extends JpaRepository<City, Integer> {

}
