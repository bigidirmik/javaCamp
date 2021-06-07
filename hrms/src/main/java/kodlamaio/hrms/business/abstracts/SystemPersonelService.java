package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.SystemPersonel;

public interface SystemPersonelService {
	
	Result add(SystemPersonel systemPersonel);
	
	DataResult<List<SystemPersonel>> getAll();
	
	DataResult<List<SystemPersonel>> getAllAsc();
	
	DataResult<List<SystemPersonel>> getAll(int pageNo, int pageSize);
	
	DataResult<SystemPersonel> findByEmail(String email);

}
