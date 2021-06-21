package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.Logo;

public interface LogoDao extends JpaRepository<Logo, Integer> {

	Logo getById(int id);
	
	Logo getByEmployer_Id(int employerId);
	
}
