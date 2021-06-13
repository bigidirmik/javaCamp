package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.SystemPersonnel;

public interface SystemPersonnelService {
	
	Result add(SystemPersonnel systemPersonnel);
	
	DataResult<List<SystemPersonnel>> getAll();
	
	DataResult<List<SystemPersonnel>> getAllAsc();
	
	DataResult<List<SystemPersonnel>> getAll(int pageNo, int pageSize);
	
	
	DataResult<SystemPersonnel> findById(int systemPersonnelId);
	
	DataResult<SystemPersonnel> findByEmail(String email);

}
