package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.JobAdvertisementActivationBySystemPersonnel;

public interface JobAdvertisementActivationBySystemPersonnelDao extends JpaRepository<JobAdvertisementActivationBySystemPersonnel, Integer> {

	JobAdvertisementActivationBySystemPersonnel getByJobAdvertisementId(int jobAdvertisementId);
	
	List<JobAdvertisementActivationBySystemPersonnel> getByConfirmerSystemPersonnelId(int confirmerSystemPersonnelId);
	
}
