package agma.studentSystem.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import agma.studentSystem.entities.concretes.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {
	List<Student> findByName(String name);

	List<Student> findByTelephone(String telephone);
	
	//List<Student> findByCityId(Integer city_id);
	
	//List<Student> findByTownId(Integer town_id);
}
