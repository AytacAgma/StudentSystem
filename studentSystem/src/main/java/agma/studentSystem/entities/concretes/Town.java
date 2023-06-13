package agma.studentSystem.entities.concretes;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="ilce")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Town {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ilce_id")
	private Integer id;
	
	@Column(name="ilce_adi")
	private String townName;
	
//	@Column(name="sehir_id")
//	private Integer cityId;
	
	@JsonBackReference
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="sehir_id")
	private City city;
	
	@JsonBackReference
	@OneToMany(mappedBy = "town", fetch=FetchType.LAZY)
	private List<Student> students;
}
