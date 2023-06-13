package agma.studentSystem.business.abstracts;

import java.util.List;

import agma.studentSystem.entities.concretes.Student;
import agma.studentSystem.entities.dtos.StudentDto;

public interface StudentService {
	List<Student> getAll();
	List<StudentDto> getAllWithNames();
	Student getByNatId(String national_id);
	List<Student> getByName(String name);
	List<Student> getByTel(String telephone);
	//List<Student> getByCity(Integer city_id);
	//List<Student> getByTown(Integer town_id);
	void add(Student student);
	void update(Student student);
	void delete(String national_id);
}
