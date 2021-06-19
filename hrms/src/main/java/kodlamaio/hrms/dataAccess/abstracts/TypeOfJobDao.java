package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.TypeOfJob;

public interface TypeOfJobDao extends JpaRepository<TypeOfJob, Integer>{

	TypeOfJob findById(int id);
	
}
