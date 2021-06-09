package kodlamaio.hrms.business.concretes;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.core.adapters.verifications.UserCheckService;
import kodlamaio.hrms.core.utilities.results.DataResult;
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
		//return this.checkForAdd(candidate); // ilgili kod satırı en altta
		this.candidateDao.save(candidate);
		return new SuccessResult("Aday eklendi");
	}
	
	@Override
	public DataResult<Candidate> getById(int candidateId) {
		return new SuccessDataResult<Candidate>(this.candidateDao.findById(candidateId));
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
	public DataResult<Candidate> findByEmail(String email) {
		return new SuccessDataResult<Candidate>(this.candidateDao.findByEmail(email),"Aday bulundu");
	}

	@Override
	public DataResult<Candidate> findByNationalityId(String nationalityId) {
		return new SuccessDataResult<Candidate>(this.candidateDao.findByNationalityId(nationalityId),"Aday bulundu");
	}

	@Override
	public DataResult<Boolean> checkIfRealPerson(String firstName, String lastName, String nationalityId, Date dateOfBirth) {
		return new SuccessDataResult<Boolean>(this.userCheckService.checkIfRealPerson(firstName, lastName, nationalityId, dateOfBirth));
	}
	
	
	// business codes
	
//	private Result checkForAdd(Candidate candidate) {
//		
//		var checkEmail = this.findByEmail(candidate.getEmail()).isSuccess();
//		var checkNationalityId = this.findByNationalityId(candidate.getNationalityId()).isSuccess();
//		var checkIfRealPerson = this.checkIfRealPerson(
//				candidate.getFirstName(),
//				candidate.getLastName(),
//				candidate.getNationalityId(),
//				candidate.getBirthOfDate()).isSuccess();
//		
//		if(checkEmail||checkNationalityId) {
//			return new ErrorResult("Kimlik numarası/Email zaten mevcut");
//		}
//		
//		else if(!checkIfRealPerson) {
//			return new ErrorResult("Lütfen kişi bilgilerini doğru giriniz");
//		}
//		
//		this.candidateDao.save(candidate);
//		EmailService.sendEmail(candidate.getEmail());
//		return new SuccessResult("Aday eklendi");
//	}

}
