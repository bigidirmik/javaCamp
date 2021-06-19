package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.WorkingTime;

public interface WorkingTimeService {
	
	Result add(WorkingTime workingTime);
	
	DataResult<WorkingTime> findById(int id);

}
