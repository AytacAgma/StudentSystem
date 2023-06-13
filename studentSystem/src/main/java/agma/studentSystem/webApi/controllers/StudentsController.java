package agma.studentSystem.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import agma.studentSystem.business.abstracts.StudentService;
import agma.studentSystem.entities.concretes.Student;
import agma.studentSystem.entities.dtos.StudentDto;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/students")
@CrossOrigin
public class StudentsController {
	private StudentService studentService;

	@Autowired
	public StudentsController(StudentService studentService) {
		this.studentService = studentService;
	}

	@GetMapping()
	public List<Student> getAll() {
		return this.studentService.getAll();
	}
	
	@GetMapping("/{nat_id}")
	public Student getByNatId(@PathVariable String nat_id) {
		return this.studentService.getByNatId(nat_id);
	}
	
	@GetMapping("/getbyname/{name}")
	public List<Student> getByName(@PathVariable String name) {
		return this.studentService.getByName(name);
	}
	
	@GetMapping("/getbytel/{tel}")
	public List<Student> getByTel(@PathVariable String tel) {
		return this.studentService.getByTel(tel);
	}
	
//	@GetMapping("/getbycity/{city_id}")
//	public List<Student> getByCity(@PathVariable Integer city_id) {
//		return this.studentService.getByCity(city_id);
//	}
//	
//	@GetMapping("/getbytown/{town_id}")
//	public List<Student> getByTown(@PathVariable Integer town_id) {
//		return this.studentService.getByTown(town_id);
//	}
	
	@PostMapping()
	public void add(@Valid Student student) {
		this.studentService.add(student);
	}
	
	@PutMapping()
	public void update(@Valid Student student) {
		this.studentService.update(student);
	}
	
	@DeleteMapping("/{nat_id}")
	public void delete(@PathVariable String nat_id) {
		this.studentService.delete(nat_id);
	}
	
	@GetMapping("/getall")
	public List<StudentDto> getAllWithNames() {
		return this.studentService.getAllWithNames();
	}
}
