package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerActivationBySystemPersonnelService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerActivationBySystemPersonnelDao;
import kodlamaio.hrms.entities.concretes.EmployerAcvtivationBySystemPersonnel;

@Service
public class EmployerActivationBySystemPersonnelManager implements EmployerActivationBySystemPersonnelService {

	private EmployerActivationBySystemPersonnelDao employerActivationBySystemPersonnelDao;

	@Autowired
	public EmployerActivationBySystemPersonnelManager(
			EmployerActivationBySystemPersonnelDao employerActivationBySystemPersonnelDao) {
		super();
		this.employerActivationBySystemPersonnelDao = employerActivationBySystemPersonnelDao;
	}

	@Override
	public DataResult<EmployerAcvtivationBySystemPersonnel> getByEmployerId(int employerId) {
		return new SuccessDataResult<EmployerAcvtivationBySystemPersonnel>(
				this.employerActivationBySystemPersonnelDao.getByEmployerId(employerId), "Data bulundu");
	}

	@Override
	public DataResult<List<EmployerAcvtivationBySystemPersonnel>> getByConfirmerSystemPersonnelId(
			int confirmerSystemPersonnelId) {
		return new SuccessDataResult<List<EmployerAcvtivationBySystemPersonnel>>(
				this.employerActivationBySystemPersonnelDao.getByConfirmerSystemPersonnelId(confirmerSystemPersonnelId),
				"Data getirildi");
	}

	@Override
	public Result add(EmployerAcvtivationBySystemPersonnel employerAcvtivationBySystemPersonnel) {
		this.employerActivationBySystemPersonnelDao.save(employerAcvtivationBySystemPersonnel);
		return new SuccessResult("İşveren onayı kaydedildi");
	}

}
