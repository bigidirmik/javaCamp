package kodlamaio.hrms.entities.concretes;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import kodlamaio.hrms.core.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "system_personels")
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class SystemPersonel extends User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "user_id")
	private int userId;

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

	@NotBlank
	@NotNull
	@Column(name = "birth_of_date")
	private Date birthOfDate;

	
//	// ORM

//	@OneToOne()
//	@JoinColumn(name = "user_id")
//	private User user;

}
