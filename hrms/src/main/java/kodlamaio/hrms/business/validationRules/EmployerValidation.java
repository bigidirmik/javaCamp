package kodlamaio.hrms.business.validationRules;

import kodlamaio.hrms.entities.concretes.Employer;

public class EmployerValidation {
	
	public static boolean allFieldsRequired(Employer employer) {
		if(
				employer.getCompanyName().strip().isEmpty()||
				employer.getWebAdress().strip().isEmpty() ||
				employer.getPhoneNumber().strip().isEmpty()||
				employer.getEmail().strip().isEmpty()||
				employer.getPassword().strip().isEmpty()){
			return false;	
		}
		return true;
	}

}
