package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.EmployerAcvtivationBySystemPersonnel;

public interface EmployerActivationBySystemPersonnelDao extends JpaRepository<EmployerAcvtivationBySystemPersonnel, Integer> {
	
	EmployerAcvtivationBySystemPersonnel getByEmployerId(int employerId);
	
	List<EmployerAcvtivationBySystemPersonnel> getByConfirmerSystemPersonnelId(int confirmerSystemPersonnelId);

}
