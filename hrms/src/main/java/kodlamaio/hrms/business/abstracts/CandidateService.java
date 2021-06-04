package kodlamaio.hrms.business.abstracts;

import java.sql.Date;
import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Candidate;

public interface CandidateService {

	Result add(Candidate candidate);
	
	DataResult<List<Candidate>> getAll();
	
	DataResult<List<Candidate>> getAllAsc();
	
	DataResult<List<Candidate>> getAll(int pageNo, int pageSize);
	
	DataResult<Candidate> findByEmail(String email);
	DataResult<Candidate> findByNationalityId(String nationalityId);
	
	DataResult<Boolean> checkIfRealPerson(String firstName, String lastName, String nationalityId, Date dateOfBirth);
	
}
