package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.User;

public interface UserService {
	
	DataResult<List<User>> getAll();
	
	DataResult<List<User>> getAllAsc();
	
	DataResult<List<User>> getAll(int pageNo, int pageSize);
	
	

}
