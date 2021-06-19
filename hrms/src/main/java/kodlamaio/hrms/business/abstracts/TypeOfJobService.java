package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.TypeOfJob;

public interface TypeOfJobService {

	Result add(TypeOfJob typeOfJob);
	
	DataResult<TypeOfJob> findById(int id);
	
}
