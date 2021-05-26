package kodlamaio.hrms.business.validationRules;

import kodlamaio.hrms.entities.concretes.Candidate;

public class CandidateValidation {
	
	public static boolean allFieldsRequired(Candidate candidate) {
		if(
				candidate.getFirstName().strip().isEmpty()||
				candidate.getLastName().strip().isEmpty()||
				candidate.getNationalityId().strip().isEmpty() ||
				candidate.getEmail().strip().isEmpty()||
				candidate.getPassword().strip().isEmpty()){
			return false;	
		}
		return true;
	}

}
