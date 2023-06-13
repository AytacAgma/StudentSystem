package agma.studentSystem.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {
	private String nationalId;
	private String name;
	private String telephone;
	private String townName;
	private String townCityName;
}
