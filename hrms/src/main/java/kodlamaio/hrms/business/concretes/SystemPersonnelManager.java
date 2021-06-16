package kodlamaio.hrms.business.concretes;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.SystemPersonnelService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.SystemPersonnelDao;
import kodlamaio.hrms.entities.concretes.SystemPersonnel;

@Service
public class SystemPersonnelManager implements SystemPersonnelService {
	
	private SystemPersonnelDao systemPersonnelDao;

	@Autowired
	public SystemPersonnelManager(SystemPersonnelDao systemPersonnelDao) {
		super();
		this.systemPersonnelDao = systemPersonnelDao;
	}
	
	@Override
	public Result add(SystemPersonnel systemPersonnel) {
		if(checkForAdd(systemPersonnel).isSuccess()) {
			this.systemPersonnelDao.save(systemPersonnel);
			return new SuccessResult("Sistem personeli eklendi");
		}
		return new ErrorResult(checkForAdd(systemPersonnel).getMessage());
	}

	@Override
	public DataResult<List<SystemPersonnel>> getAll() {
		return new SuccessDataResult<List<SystemPersonnel>>(this.systemPersonnelDao.findAll(),"Sistem personeli listelendi");
	}
	
	@Override
	public DataResult<List<SystemPersonnel>> getAllAsc() {
		Sort sort = Sort.by(Sort.Direction.ASC,"firstName");
		return new SuccessDataResult<List<SystemPersonnel>>(this.systemPersonnelDao.findAll(sort),"Sistem personeli listelendi");
	}

	@Override
	public DataResult<List<SystemPersonnel>> getAll(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo-1, pageSize);
		return new SuccessDataResult<List<SystemPersonnel>>(this.systemPersonnelDao.findAll(pageable).getContent(),"Sistem personeli listelendi");
	}
	
	
	@Override
	public DataResult<SystemPersonnel> findById(int systemPersonnelId) {
		return new SuccessDataResult<SystemPersonnel>(this.systemPersonnelDao.findById(systemPersonnelId),"Sistem personeli bulundu");
	}

	@Override
	public DataResult<SystemPersonnel> findByEmail(String email) {
		var data = this.systemPersonnelDao.findByEmail(email);
		if(data==null) {
			return new ErrorDataResult<SystemPersonnel>("Sistem personeli bulunamadı");
		}
		return new SuccessDataResult<SystemPersonnel>(data,"Sistem personeli bulundu");
	}
	
	
	// business codes
	private Result checkForAdd(SystemPersonnel systemPersonnel) {
		
		var checkEmail = this.findByEmail(systemPersonnel.getEmail());
		
		var checkBirthOfDate = !LocalDate.now().isBefore(systemPersonnel.getBirthOfDate().toLocalDate());
		
		if(checkEmail.isSuccess()) {
			return new ErrorResult("Email zaten mevcut");
		}
		
		else if(checkBirthOfDate) {
			return new ErrorResult("Lütfen bugünden önce bir doğum tarihi giriniz");
		}
		
		return new SuccessResult();
		
	}

}
