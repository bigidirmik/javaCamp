package kodlamaio.hrms.entities.concretes;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "job_advertisements")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@NotBlank
	@NotNull
	@Column(name = "description")
	private String description;

	@Column(name = "salary_min")
	private double salaryMin;

	@Column(name = "salary_max")
	private double salaryMax;

	@Column(name = "position_quota")
	private int positionQuota;

	@Column(name = "application_deadline")
	private Date applicationDeadline;

	@Column(name = "is_active")
	private boolean isActive;
	
	@Column(name = "is_confirmed")
	private boolean isConfirmed;

	// ORM

	@ManyToOne()
	@JoinColumn(name = "employer_id")
	private Employer employer;

	@ManyToOne()
	@JoinColumn(name = "jobTitle_id")
	private JobTitle jobTitle;

	@ManyToOne()
	@JoinColumn(name = "city_id")
	private City city;
	
	@ManyToOne()
	@JoinColumn(name = "typeOfJob_id")
	private TypeOfJob typeOfJob;
	
	@ManyToOne()
	@JoinColumn(name = "workingTime_id")
	private WorkingTime workingTime;

}
