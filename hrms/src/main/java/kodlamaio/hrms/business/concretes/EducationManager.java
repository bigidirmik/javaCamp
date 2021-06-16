package kodlamaio.hrms.business.concretes;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EducationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EducationDao;
import kodlamaio.hrms.entities.concretes.Education;

@Service
public class EducationManager implements EducationService {

	private EducationDao educationDao;

	@Autowired
	public EducationManager(EducationDao educationDao) {
		super();
		this.educationDao = educationDao;
	}

	@Override
	public Result add(Education education) {
		if(checkForAdd(education).isSuccess()) {
			this.educationDao.save(education);
			return new SuccessResult("Eğitim bilgisi eklendi");
		}
		return new ErrorResult(checkForAdd(education).getMessage());
	}

	@Override
	public DataResult<List<Education>> getAllByCandidateIdOrderByEndDateDesc(int candidateId) {
		return new SuccessDataResult<List<Education>>(this.educationDao.getAllByCandidate_IdOrderByEndDateDesc(candidateId),"Eğitim bilgisi bulundu");
	}
	
	// business codes
	
	private Result checkForAdd(Education education) {
		var endDateCheck = !LocalDate.now().isAfter(education.getEndDate().toLocalDate());
		var startDateCheck = !education.getEndDate().after(education.getStartDate());
		
		if(endDateCheck&&startDateCheck){
			return new ErrorResult("Lütfen doğru bir tarih giriniz");
		}
		
		return new SuccessResult();
	}
	
}
