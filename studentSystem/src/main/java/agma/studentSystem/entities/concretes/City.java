package agma.studentSystem.entities.concretes;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="sehir")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class City {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="sehir_id")
	private Integer id;
	
	@Column(name="sehir_adi")
	private String cityName;
	
	@JsonBackReference
	@OneToMany(mappedBy = "city", fetch=FetchType.LAZY)
	private List<Town> towns;
}
