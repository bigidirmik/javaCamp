package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.entities.User;
import kodlamaio.hrms.core.utilities.results.DataResult;

public interface UserService {
	
	DataResult<List<User>> getAll();
	
	DataResult<List<User>> getAllAsc();
	
	DataResult<List<User>> getAll(int pageNo, int pageSize);
	
	
	DataResult<User> findByEmail(String email);

}
