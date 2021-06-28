package kodlamaio.hrms.entities.concretes;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import kodlamaio.hrms.core.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "candidates")
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class Candidate extends User {

	@JsonIgnore
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

//	@Column(name = "user_id")
//	private int userId;

	@NotBlank
	@NotNull
	@Column(name = "first_name")
	private String firstName;

	@NotBlank
	@NotNull
	@Column(name = "last_name")
	private String lastName;

	@NotBlank
	@NotNull
	@Column(name = "nationality_id")
	private String nationalityId;

	//@NotBlank
	//@NotNull
	@Column(name = "birth_of_date")
	private Date birthOfDate;
	
	
	// ORM
	
	@JsonIgnore
	@OneToOne()
	@JoinColumn(name = "id")
	private User user;
	
	@JsonIgnore
	@OneToMany(mappedBy = "candidate")
	private List<Education> educations;
	
	@JsonIgnore
	@OneToMany(mappedBy = "candidate")
	private List<WorkExperience> workExperiences;
	
	@JsonIgnore
	@OneToMany(mappedBy = "candidate")
	private List<Language> languages;
	
	@OneToOne(mappedBy = "candidate")
	private Image image;
	
	@JsonIgnore
	@OneToMany(mappedBy = "candidate")
	private List<Network> networks;
	
	@JsonIgnore
	@OneToMany(mappedBy = "candidate")
	private List<Skill> skills;
	
	@JsonIgnore
	@OneToOne(mappedBy = "candidate")
	private CoverLetter coverLetter;
	
}