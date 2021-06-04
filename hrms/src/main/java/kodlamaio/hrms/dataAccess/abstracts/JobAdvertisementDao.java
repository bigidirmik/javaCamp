package kodlamaio.hrms.dataAccess.abstracts;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {

	List<JobAdvertisement> getByIsActive(boolean isActive);
	
	List<JobAdvertisement> getByIsActiveAndApplicationDeadline(boolean isActive, Date applicationDeadline);
	
	List<JobAdvertisement> getByIsActiveAndEmployer_Id(boolean isActive, int employerId);
	
	
	// Tarih sırasına göre sıralamak için Query - Manager'da ASC olarak yazılacak
	
	@Query("From JobAdvertisement where isActive=:isActive and applicationDeadline=:applicationDeadline")
	List<JobAdvertisement> getByQueryActiveAndAppDeadlineAsc(boolean isActive, Date applicationDeadline);
	
}
