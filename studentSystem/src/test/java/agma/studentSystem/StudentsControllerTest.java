package agma.studentSystem;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import agma.studentSystem.business.abstracts.StudentService;
import agma.studentSystem.entities.concretes.Student;
import agma.studentSystem.webApi.controllers.StudentsController;

@SpringBootTest
//@RunWith(MockitoJUnitRunner.class)
public class StudentsControllerTest {
	private MockMvc mockMvc;

	ObjectMapper objectMapper = new ObjectMapper();
	ObjectWriter objectWriter = objectMapper.writer();

	@Mock
	private StudentService studentService;
	@InjectMocks
	private StudentsController studentsController;

	Student record_1 = new Student("65748943504", "Control Account", "05556580394", null, null);
	Student record_2 = new Student("65748943506", "Test Account", "05556580396", null, null);
	Student record_3 = new Student("65748943508", "Security Account", "05556580398", null, null);

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(studentsController).build();
	}

	@Test
	public void getAllRecords_success() throws Exception {
		List<Student> records = new ArrayList<>(Arrays.asList(record_1,record_2,record_3));
		
		Mockito.when(studentService.getAll()).thenReturn(records);
		
//		try {
			mockMvc.perform(MockMvcRequestBuilders
				.get("/api/students")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(3)))
				.andExpect(MockMvcResultMatchers.jsonPath("$[1].name", is("Test Account")))
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].nationalId", is("65748943504")));
//		}
//		catch (Exception ex){ 
//			throw ex.getCause();
//		}
		
	}
	
	@Test
	public void getByNationalId_success() throws Exception {
		Mockito.when(studentService.getByNatId(record_3.getNationalId())).thenReturn(record_3);
		
			mockMvc.perform(MockMvcRequestBuilders
				.get("/api/students/65748943508")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$", notNullValue()))
				.andExpect(MockMvcResultMatchers.jsonPath("$.telephone", is("05556580398")));
		
	}

}
