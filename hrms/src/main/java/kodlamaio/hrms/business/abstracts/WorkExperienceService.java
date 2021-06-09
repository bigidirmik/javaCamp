package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.WorkExperience;

public interface WorkExperienceService {
	
	Result add(WorkExperience workExperience);
	
	DataResult<List<WorkExperience>> getAllByCandidateIdOrderByEndDateDesc(int candidateId);

}
