package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.TypeOfJobService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.TypeOfJobDao;
import kodlamaio.hrms.entities.concretes.TypeOfJob;

@Service
public class TypeOfJobManager implements TypeOfJobService{
	
	private TypeOfJobDao typeOfJobDao;

	@Autowired
	public TypeOfJobManager(TypeOfJobDao typeOfJobDao) {
		super();
		this.typeOfJobDao = typeOfJobDao;
	}

	@Override
	public Result add(TypeOfJob typeOfJob) {
		this.typeOfJobDao.save(typeOfJob);
		return new SuccessResult("Çalışma tipi eklendi");
	}

	@Override
	public DataResult<TypeOfJob> findById(int id) {
		return new SuccessDataResult<TypeOfJob>(this.typeOfJobDao.findById(id),"Çalışma tipi bulundu");
	}

	@Override
	public DataResult<List<TypeOfJob>> getAll() {
		return new SuccessDataResult<List<TypeOfJob>>(this.typeOfJobDao.findAll(),"Çalışma tipleri listelendi");
	}

}
