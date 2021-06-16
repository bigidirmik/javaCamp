package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobTitle;

public interface JobTitleService {
	
	Result add(JobTitle jobTitle);
	
	DataResult<List<JobTitle>> getAll();
	
	DataResult<List<JobTitle>> getAllAsc();
	
	DataResult<List<JobTitle>> getAll(int pageNo, int pageSize);
	
	DataResult<JobTitle> findById(int jobTitleId);
	
}
