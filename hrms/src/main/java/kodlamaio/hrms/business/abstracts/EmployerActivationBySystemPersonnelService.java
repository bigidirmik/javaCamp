package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.EmployerAcvtivationBySystemPersonnel;

public interface EmployerActivationBySystemPersonnelService {
	
	Result add(EmployerAcvtivationBySystemPersonnel employerAcvtivationBySystemPersonnel);
	
	DataResult<EmployerAcvtivationBySystemPersonnel> getByEmployerId(int employerId);
	
	DataResult<List<EmployerAcvtivationBySystemPersonnel>> getByConfirmerSystemPersonnelId(int confirmerSystemPersonnelId);

}
