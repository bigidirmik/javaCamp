package kodlamaio.hrms.business.abstracts;

import java.sql.Date;
import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementService {

	Result add(JobAdvertisement jobAdvertisement);
	
	Result setActivityStatus(int id, boolean status);
	
	DataResult<List<JobAdvertisement>> getAll();
	
	DataResult<List<JobAdvertisement>> getAllAsc();
	
	DataResult<List<JobAdvertisement>> getAll(int pageNo, int pageSize);
	
	
	DataResult<List<JobAdvertisement>> getByIsActive(boolean isActive);
	
	DataResult<List<JobAdvertisement>> getByIsActiveAndApplicationDeadline(boolean isActive, Date applicationDeadline);
	
	DataResult<List<JobAdvertisement>> getByIsActiveAndEmployerId(boolean isActive, int employerId);
	
	//Query Method
	DataResult<List<JobAdvertisement>> getByQueryActiveAndAppDeadlineAsc(boolean isActive, Date applicationDeadline);
	
}
