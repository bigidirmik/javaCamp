package kodlamaio.hrms.business.concretes;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.WorkExperienceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.WorkExperienceDao;
import kodlamaio.hrms.entities.concretes.WorkExperience;

@Service
public class WorkExperienceManager implements WorkExperienceService{
	
	private WorkExperienceDao workExperienceDao;

	@Autowired
	public WorkExperienceManager(WorkExperienceDao workExperienceDao) {
		super();
		this.workExperienceDao = workExperienceDao;
	}

	@Override
	public Result add(WorkExperience workExperience) {
		if(checkForAdd(workExperience).isSuccess()) {
			this.workExperienceDao.save(workExperience);
			return new SuccessResult("İş tecrübesi eklendi");
		}
		return new ErrorResult(checkForAdd(workExperience).getMessage());
	}

	@Override
	public DataResult<List<WorkExperience>> getAllByCandidateIdOrderByEndDateDesc(int candidateId) {
		return new SuccessDataResult<List<WorkExperience>>(this.workExperienceDao.getAllByCandidate_IdOrderByEndDateDesc(candidateId),"iş tecrübesi bulundu");
	}
	
	
	// business codes
	
	private Result checkForAdd(WorkExperience workExperience) {
		var endDateCheck = !LocalDate.now().isAfter(workExperience.getEndDate().toLocalDate());
		var startDateCheck = !workExperience.getEndDate().after(workExperience.getStartDate());
		
		if(endDateCheck&&startDateCheck){
			return new ErrorResult("Lütfen doğru bir tarih giriniz");
		}
		
		return new SuccessResult();
	}
	

}
