package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService {
	
	private EmployerDao employerDao;

	@Autowired
	public EmployerManager(EmployerDao employerDao) {
		super();
		this.employerDao = employerDao;
	}

	@Override
	public Result add(Employer employer) {
		if(checkForAdd(employer).isSuccess()) {
			this.employerDao.save(employer);
			return new SuccessResult("İşveren eklendi");
		}
		return new ErrorResult(checkForAdd(employer).getMessage());
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(),"İşverenler listelendi");
	}
	
	@Override
	public DataResult<List<Employer>> getAllAsc() {
		Sort sort = Sort.by(Sort.Direction.ASC,"companyName");
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(sort),"İşverenler listelendi");
	}
	
	@Override
	public DataResult<List<Employer>> getAll(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo-1, pageSize);
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(pageable).getContent(),"İşverenler listelendi");
	}

	
	@Override
	public DataResult<Employer> findById(int employerId) {
		return new SuccessDataResult<Employer>(this.employerDao.findById(employerId));
	}

	@Override
	public DataResult<Employer> findByEmail(String email) {
		var data = this.employerDao.findByEmail(email);
		if(data==null) {
			return new ErrorDataResult<Employer>("İşveren bulunamadı");
		}
		return new SuccessDataResult<Employer>(data,"İşveren bulundu");
	}
	
	
	// business codes
	
	private Result checkForAdd(Employer employer) {
		
		var checkEmail = this.findByEmail(employer.getEmail());
		//var checkWebAdress = (employer.getEmail() == employer.getWebAdress()).isSuccess();
		
		if(checkEmail.isSuccess()) {
			return new ErrorResult("Email zaten mevcut");
		}
		
		//EmailService;
		
		return new SuccessResult("checkForAdd : OK");
	}

}
