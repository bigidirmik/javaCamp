package kodlamaio.hrms.dataAccess.abstracts;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {

	List<JobAdvertisement> getByIsActive(boolean isActive);
	
	List<JobAdvertisement> getByIsActiveAndApplicationDeadline(boolean isActive, Date applicationDeadline);
	
	List<JobAdvertisement> getByIsActiveAndEmployerId(boolean isActive, int employerId);
	
}
