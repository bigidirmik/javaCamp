package kodlamaio.hrms.entities.concretes;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employer_activations_by_system_personnel")
public class EmployerAcvtivationBySystemPersonnel {

	@JsonIgnore
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "employer_id")
	private int employerId;
	
	@Column(name = "confirmer_system_personnel_id")
	private int confirmerSystemPersonnelId;
	
//	@Column(name = "is_confirmed")
//	private boolean isConfirmed;
	//employer içinde isConfirmed zaten var, burada sadece kimin aktif ettiği bilgisi olsa yeter
	
	@Column(name = "confirmed_date")
	private Date confirmedDate;
	
}
