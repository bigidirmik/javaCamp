package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Network;

public interface NetworkService {

	Result add(Network network);
	
	DataResult<List<Network>> getAllByCandidateId(int candidateId);
	
}
