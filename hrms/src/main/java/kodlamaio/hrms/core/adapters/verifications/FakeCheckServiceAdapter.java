package kodlamaio.hrms.core.adapters.verifications;

import java.sql.Date;

import org.springframework.stereotype.Service;

@Service
public class FakeCheckServiceAdapter implements UserCheckService {

	@Override
	public boolean checkIfRealPerson(String firstName, String lastName, String nationalityId, Date dateOfBirth) {
		return true;
	}

}
