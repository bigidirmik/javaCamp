package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.Network;

public interface NetworkDao extends JpaRepository<Network, Integer>{
	
	List<Network> getByCandidate_Id(int candidateId);

}
