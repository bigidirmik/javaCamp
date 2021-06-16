package kodlamaio.hrms.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.abstracts.NetworkService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.Network;

@RestController
@RequestMapping("/api/networks")
@CrossOrigin
public class NetworksController {
	
	private NetworkService networkService;
	private CandidateService candidateService;

	@Autowired 
	public NetworksController(NetworkService networkService, CandidateService candidateService) {
		super();
		this.networkService = networkService;
		this.candidateService = candidateService;
	}
	
	@PostMapping("/add")
	public Result add(int candidateId, @RequestBody Network network) {
		Candidate candidate = this.candidateService.findById(candidateId).getData();
		network.setCandidate(candidate);
		return this.networkService.add(network);
	}
	
	@GetMapping("/getAllByCandidateId")
	public DataResult<List<Network>> getAllByCandidateId(@RequestParam int candidateId){
		return this.networkService.getAllByCandidateId(candidateId);
	}

}
