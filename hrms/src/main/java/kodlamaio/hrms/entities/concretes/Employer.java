package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employers")
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class Employer extends User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "user_id")
	private int userId;
	
	@Column(name = "company_name")
	private String companyName;
	
	@Column(name = "web_adress")
	private String webAdress;
	
	@Column(name = "phone_number")
	private String phoneNumber;
	
	// tablodaki is_activated booelan alanı eklenmedi, gerekmediği anlaşılırsa ise tablodan sileceğim.
	
	//ORM
	
	//@OneToMany(mappedBy = "job_advertisements")
	//private List<JobAdvertisement> jobAdvertisements;
	
}
