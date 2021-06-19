package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employer;

public interface EmployerService {
	
	Result add(Employer employer);
	
	Result setConfirmationStatus(int employerId, boolean status);
	
	DataResult<List<Employer>> getAll();
	
	DataResult<List<Employer>> getAllAsc();
	
	DataResult<List<Employer>> getAll(int pageNo, int pageSize);
	
	
	DataResult<Employer> findById(int employerId);
	
	DataResult<Employer> findByEmail(String email);
	
	DataResult<List<Employer>> getByIsConfirmed(boolean isConfirmed);

}
