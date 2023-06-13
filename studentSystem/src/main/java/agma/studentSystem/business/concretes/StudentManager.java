package agma.studentSystem.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import agma.studentSystem.business.abstracts.StudentService;
import agma.studentSystem.core.utilities.mappers.ModelMapperService;
import agma.studentSystem.dataAccess.abstracts.StudentRepository;
import agma.studentSystem.entities.concretes.Student;
import agma.studentSystem.entities.dtos.StudentDto;

@Service
public class StudentManager implements StudentService {
	private StudentRepository studentRepository;
	private ModelMapperService modelMapperService;

	@Autowired
	public StudentManager(StudentRepository studentRepository, ModelMapperService modelMapperService) {
		this.studentRepository = studentRepository;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public List<Student> getAll() {
		return this.studentRepository.findAll();
	}
	
	@Override
	public Student getByNatId(String national_id) {
		return this.studentRepository.findById(national_id).orElseThrow();
	}

	@Override
	public List<Student> getByName(String name) {
		return this.studentRepository.findByName(name);
	}

	@Override
	public List<Student> getByTel(String telephone) {
		return this.studentRepository.findByTelephone(telephone);
	}

//	@Override
//	public List<Student> getByCity(Integer city_id) {
//		return this.studentRepository.findByCityId(city_id);
//	}

//	@Override
//	public List<Student> getByTown(Integer town_id) {
//		return this.studentRepository.findByTownId(town_id);
//	}

	@Override
	public void add(Student student) {
		this.studentRepository.save(student);		
	}

	@Override
	public void update(Student student) {
		this.studentRepository.save(student);	
	}

	@Override
	public void delete(String national_id) {
		this.studentRepository.deleteById(national_id);
	}

	@Override
	public List<StudentDto> getAllWithNames() {
		List<Student> students = this.studentRepository.findAll();
		
		List<StudentDto> studentDto = students.stream()
				.map(student->this.modelMapperService.forResponse()
						.map(student, StudentDto.class)).collect(Collectors.toList());
		
		return studentDto;
	}

}
