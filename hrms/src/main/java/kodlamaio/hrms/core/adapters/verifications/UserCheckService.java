package kodlamaio.hrms.core.adapters.verifications;

import java.sql.Date;

public interface UserCheckService {

	boolean checkIfRealPerson(String firstName, String lastName, String nationalityId, Date dateOfBirth);
	
}
