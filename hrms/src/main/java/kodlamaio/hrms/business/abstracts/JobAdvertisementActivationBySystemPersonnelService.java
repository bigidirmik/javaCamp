package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisementActivationBySystemPersonnel;

public interface JobAdvertisementActivationBySystemPersonnelService {
	
	Result add(JobAdvertisementActivationBySystemPersonnel jobAdvertisementActivationBySystemPersonnel);
	
	DataResult<JobAdvertisementActivationBySystemPersonnel> getByJobAdvertisementId(int jobAdvertisementId);
	
	DataResult<List<JobAdvertisementActivationBySystemPersonnel>> getByConfirmerSystemPersonnelId(int confirmerSystemPersonnelId);

}
