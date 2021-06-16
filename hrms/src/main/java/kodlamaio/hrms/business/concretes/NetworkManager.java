package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.NetworkService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.NetworkDao;
import kodlamaio.hrms.entities.concretes.Network;

@Service
public class NetworkManager implements NetworkService {
	
	private NetworkDao networkDao;

	@Autowired
	public NetworkManager(NetworkDao networkDao) {
		super();
		this.networkDao = networkDao;
	}

	@Override
	public Result add(Network network) {
		this.networkDao.save(network);
		return new SuccessResult("Ağ eklendi");
	}

	@Override
	public DataResult<List<Network>> getAllByCandidateId(int candidateId) {
		return new SuccessDataResult<List<Network>>(this.networkDao.getAllByCandidate_Id(candidateId),"Ağlar bulundu");
	}
	

}
