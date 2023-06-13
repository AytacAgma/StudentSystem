package agma.studentSystem.entities.concretes;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Table(name="ogrenci")
@Entity
public class Student {
	@Id
	@Size(min=11, max=11)
	@Column(name="kimlik_no")
	private String nationalId;
	
	@NotNull
	@NotBlank
	@Column(name="ad")
	private String name;
	
	@Column(name="telefon")
	private String telephone;
	
//	@Column(name="sehir_id")
//	private Integer cityId;
//	
//	@Column(name="ilce_id")
//	private Integer townId;
	
	@JsonBackReference
	@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "ilce_id")
    private Town town;
	
	@Column(name="islem_tarih", nullable = false, updatable = false)
	@CreationTimestamp
	private Timestamp processDate;
	
	public Student() {
	}

	public Student(@Size(min = 11, max = 11) String nationalId, @NotNull @NotBlank String name,
			@Size(max = 11) String telephone, Town town, Timestamp processDate) {
		super();
		this.nationalId = nationalId;
		this.name = name;
		this.telephone = telephone;
		this.town = town;
		this.processDate = processDate;
	}

	public String getNationalId() {
		return nationalId;
	}

	public void setNationalId(String nationalId) {
		this.nationalId = nationalId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Town getTown() {
		return town;
	}

	public void setTown(Town town) {
		this.town = town;
	}

	public Timestamp getProcessDate() {
		return processDate;
	}

	public void setProcessDate(Timestamp processDate) {
		this.processDate = processDate;
	}

	
}
