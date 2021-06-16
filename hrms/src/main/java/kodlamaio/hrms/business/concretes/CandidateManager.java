package kodlamaio.hrms.business.concretes;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.core.adapters.verifications.UserCheckService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.entities.concretes.Candidate;

@Service
public class CandidateManager implements CandidateService {

	private CandidateDao candidateDao;
	private UserCheckService userCheckService;
	
	@Autowired
	public CandidateManager(CandidateDao candidateDao, UserCheckService userCheckService) {
		super();
		this.candidateDao = candidateDao;
		this.userCheckService = userCheckService;
	}

	@Override
	public Result add(Candidate candidate) {
		if(checkForAdd(candidate).isSuccess()) {
			this.candidateDao.save(candidate);
			return new SuccessResult("Aday eklendi");
		}
		return new ErrorResult(checkForAdd(candidate).getMessage());
	}

	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(),"Adaylar listelendi");
	}
	
	@Override
	public DataResult<List<Candidate>> getAllAsc() {
		Sort sort = Sort.by(Sort.Direction.ASC,"firstName");
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(sort),"Adaylar listelendi");
	}
	
	@Override
	public DataResult<List<Candidate>> getAll(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo-1, pageSize);
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(pageable).getContent(),"Adaylar listelendi");
	}
	
	
	@Override
	public DataResult<Candidate> findById(int candidateId) {
		return new SuccessDataResult<Candidate>(this.candidateDao.findById(candidateId),"Aday bulundu");
	}

	@Override
	public DataResult<Candidate> findByEmail(String email) {
		var data = this.candidateDao.findByEmail(email);
		if(data==null) {
			return new ErrorDataResult<Candidate>("Aday bulunamadı");
		}
		return new SuccessDataResult<Candidate>(data,"Aday bulundu");
	}

	@Override
	public DataResult<Candidate> findByNationalityId(String nationalityId) {
		var data = this.candidateDao.findByNationalityId(nationalityId);
		if(data==null) {
			return new ErrorDataResult<Candidate>("Aday bulunamadı");
		}
		return new SuccessDataResult<Candidate>(data,"Aday bulundu");
	}

	
	//
	@Override
	public DataResult<Boolean> checkIfRealPerson(String firstName, String lastName, String nationalityId, Date dateOfBirth) {
		return new SuccessDataResult<Boolean>(this.userCheckService.checkIfRealPerson(firstName, lastName, nationalityId, dateOfBirth));
	}
	
	
	// business codes
	
	private Result checkForAdd(Candidate candidate) {
		
		var checkEmail = this.findByEmail(candidate.getEmail());
		
		var checkNationalityId = this.findByNationalityId(candidate.getNationalityId());
		
		var checkBirthOfDate = !LocalDate.now().isAfter(candidate.getBirthOfDate().toLocalDate());
		
//		var checkIfRealPerson = this.userCheckService.checkIfRealPerson(
//				candidate.getFirstName(),
//				candidate.getLastName(),
//				candidate.getNationalityId(),
//				candidate.getBirthOfDate());
		
		if(checkEmail.isSuccess()||checkNationalityId.isSuccess()) {
			return new ErrorResult("Kimlik numarası/Email zaten mevcut");
		}
		
		else if(checkBirthOfDate) {
			return new ErrorResult("Lütfen bugünden önce bir doğum tarihi giriniz");
		}
		
//		else if(!checkIfRealPerson) {
//			return new ErrorResult("Lütfen kişi bilgilerini doğru giriniz");
//		}

		//EmailService; // core helper içinde, entegre ederken kontrol et
		
		return new SuccessResult("checkForAdd : OK");
	}

}
