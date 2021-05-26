package kodlamaio.hrms.core.adapters.verifications;

import java.sql.Date;

public class FakeCheckServiceAdapter implements UserCheckService {

	@Override
	public boolean checkIfRealPerson(String firstName, String lastName, String nationalityId, Date dateOfBirth) {
		return true;
	}

}
