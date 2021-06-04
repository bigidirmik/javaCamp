package kodlamaio.hrms.business.concretes;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {

	private JobAdvertisementDao jobAdvertisementDao;

	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
	}

	@Override
	public Result add(JobAdvertisement jobAdvertisement) {
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("İş ilanı eklendi");
	}
	
	@Override
	public Result setActivityStatus(int id, boolean status) {
		var advertisement = this.jobAdvertisementDao.getOne(id);
		advertisement.setActive(status);
		this.jobAdvertisementDao.save(advertisement);
		return new SuccessResult("İlan aktifliği: " + status);
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(),"Data listelendi");
	}
	
	@Override
	public DataResult<List<JobAdvertisement>> getAllAsc() {
		Sort sort = Sort.by(Sort.Direction.ASC,"jobTitle_id"); // sıralı gelmez ise jobtitle_id kısmını kurcala
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(sort),"Data listelendi");
	}
	
	@Override
	public DataResult<List<JobAdvertisement>> getAll(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo-1, pageSize);
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(pageable).getContent(),"Data listelendi");
	}
	

	@Override
	public DataResult<List<JobAdvertisement>> getByIsActive(boolean isActive) {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByIsActive(isActive),"Data listelendi");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByIsActiveAndApplicationDeadline(boolean isActive, Date applicationDeadline) {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByIsActiveAndApplicationDeadline(isActive, applicationDeadline),"Data listelendi");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByIsActiveAndEmployerId(boolean isActive, int employerId) {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByIsActiveAndEmployer_Id(isActive, employerId),"Data listelendi");
	}

	// Query Method
	@Override
	public DataResult<List<JobAdvertisement>> getByQueryActiveAndAppDeadlineAsc(boolean isActive, Date applicationDeadline) {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByQueryActiveAndAppDeadlineAsc(isActive, applicationDeadline),"Data listelendi");
	}
	
}
