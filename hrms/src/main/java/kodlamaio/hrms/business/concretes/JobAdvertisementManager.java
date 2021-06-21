package kodlamaio.hrms.business.concretes;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
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
		if(checkForAdd(jobAdvertisement).isSuccess()) {
			this.jobAdvertisementDao.save(jobAdvertisement);
			return new SuccessResult("İş ilanı eklendi");
		}
		return new ErrorResult(checkForAdd(jobAdvertisement).getMessage());
	}
	
	
	@Override
	public Result setActivityStatus(int jobAdvertisementId, boolean status) {
		var advertisement = this.jobAdvertisementDao.getOne(jobAdvertisementId);
		advertisement.setActive(status);
		this.jobAdvertisementDao.save(advertisement);
		return new SuccessResult("İlan aktifliği : " + status);
	}
	
	@Override
	public Result setConfirmationStatus(int jobAdvertisementId, boolean status) {
		var advertisement = this.jobAdvertisementDao.getOne(jobAdvertisementId);
		var checkDeadLine = LocalDate.now().isBefore(advertisement.getApplicationDeadline().toLocalDate());
		if (checkDeadLine) {
			advertisement.setConfirmed(status);
			this.jobAdvertisementDao.save(advertisement);
			return new SuccessResult("Sistem Personeli onayı :" + status);
		}
		return new ErrorResult("İlan tarihi güncel değil! İlan aktif edilemez");
	}
	

	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(),"Data listelendi");
	}
	
	@Override
	public DataResult<List<JobAdvertisement>> getAllAsc() {
		Sort sort = Sort.by(Sort.Direction.ASC,"jobTitle_id"); // sıralı gelmez ise jobtitle_id kısmını kurcala // işlerin kategorisine göre sıralanması
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(sort),"Data listelendi");
	}
	
	@Override
	public DataResult<List<JobAdvertisement>> getAll(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo-1, pageSize);
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(pageable).getContent(),"Data listelendi");
	}
	
	

	@Override
	public DataResult<List<JobAdvertisement>> getByIsActive(boolean isActive) {
		this.setActivationsByDeadLine();
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByIsActive(isActive),"Data listelendi");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByIsConfirmed(boolean isConfirmed) {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByIsConfirmed(isConfirmed),"Data listelendi");
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
	
	
	// business codes
	
	private Result checkForAdd(JobAdvertisement jobAdvertisement) {
		
		var checkDeadLine = !LocalDate.now().isBefore(jobAdvertisement.getApplicationDeadline().toLocalDate());
		
		if(checkDeadLine) {
			return new ErrorResult("Lütfen doğru bir tarih giriniz");
		}
		
		else if(jobAdvertisement.getPositionQuota()<=0) {
			return new ErrorResult("Lütfen doğru bir kota giriniz");
		}
		
		else if(jobAdvertisement.getSalaryMin()<0 || jobAdvertisement.getSalaryMax()<jobAdvertisement.getSalaryMin()) {
			return new ErrorResult("Lütfen ücretlendirmeyi doğru giriniz");
		}
		return new SuccessResult();
	}
	
	
	private void setActivationsByDeadLine() {
		var jobAdvertisements = this.getByIsActive(true).getData();
		for (JobAdvertisement jobAdvertisement : jobAdvertisements) {
			var checkDeadLine = LocalDate.now().isAfter(jobAdvertisement.getApplicationDeadline().toLocalDate());
			if (checkDeadLine) {
				jobAdvertisement.setActive(false);
				System.out.println("Tarihi geçen ilanlar de-aktif edildi");
			}
		}
	}
	
}
