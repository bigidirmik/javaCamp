package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobTitleService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobTitleDao;
import kodlamaio.hrms.entities.concretes.JobTitle;

@Service
public class JobTitleManager implements JobTitleService {

	private JobTitleDao jobTitleDao;
	
	
	@Autowired
	public JobTitleManager(JobTitleDao jobTitleDao) {
		super();
		this.jobTitleDao = jobTitleDao;
	}

	
	@Override
	public DataResult<List<JobTitle>> getAll() {
		return new SuccessDataResult<List<JobTitle>>(this.jobTitleDao.findAll(),"Data listelendi");
	}
	
	@Override
	public DataResult<List<JobTitle>> getAllAsc() {
		Sort sort = Sort.by(Sort.Direction.ASC,"title");
		return new SuccessDataResult<List<JobTitle>>(this.jobTitleDao.findAll(sort),"Data listelendi");
	}
	
	@Override
	public DataResult<List<JobTitle>> getAll(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo-1, pageSize);
		return new SuccessDataResult<List<JobTitle>>(this.jobTitleDao.findAll(pageable).getContent(),"Data listelendi");
	}


	@Override
	public Result add(JobTitle jobTitle) {
		var checkTitleExist = this.jobTitleDao.findAll().contains(jobTitle);
		
		if(checkTitleExist) {
			return new ErrorResult("Bu başlık zaten mevcut");
		}
		
		this.jobTitleDao.save(jobTitle);
		return new SuccessResult("İş dalı eklendi");
	}

}
