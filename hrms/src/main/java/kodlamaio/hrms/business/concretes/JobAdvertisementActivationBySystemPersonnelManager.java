package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobAdvertisementActivationBySystemPersonnelService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertisementActivationBySystemPersonnelDao;
import kodlamaio.hrms.entities.concretes.JobAdvertisementActivationBySystemPersonnel;

@Service
public class JobAdvertisementActivationBySystemPersonnelManager
		implements JobAdvertisementActivationBySystemPersonnelService {

	private JobAdvertisementActivationBySystemPersonnelDao jobAdvertisementActivationBySystemPersonnelDao;

	@Autowired
	public JobAdvertisementActivationBySystemPersonnelManager(
			JobAdvertisementActivationBySystemPersonnelDao jobAdvertisementActivationBySystemPersonnelDao) {
		super();
		this.jobAdvertisementActivationBySystemPersonnelDao = jobAdvertisementActivationBySystemPersonnelDao;
	}

	@Override
	public DataResult<JobAdvertisementActivationBySystemPersonnel> getByJobAdvertisementId(int jobAdvertisementId) {
		return new SuccessDataResult<JobAdvertisementActivationBySystemPersonnel>(
				this.jobAdvertisementActivationBySystemPersonnelDao.getByJobAdvertisementId(jobAdvertisementId),
				"Data bulundu");
	}

	@Override
	public DataResult<List<JobAdvertisementActivationBySystemPersonnel>> getByConfirmerSystemPersonnelId(
			int confirmerSystemPersonnelId) {
		return new SuccessDataResult<List<JobAdvertisementActivationBySystemPersonnel>>(
				this.jobAdvertisementActivationBySystemPersonnelDao
						.getByConfirmerSystemPersonnelId(confirmerSystemPersonnelId),
				"Data listelendi");
	}

	@Override
	public Result add(JobAdvertisementActivationBySystemPersonnel jobAdvertisementActivationBySystemPersonnel) {
		this.jobAdvertisementActivationBySystemPersonnelDao.save(jobAdvertisementActivationBySystemPersonnel);
		return new SuccessResult("İş ilanı onayı kaydedildi");
	}

}
