package kodlamaio.hrms.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.abstracts.CoverLetterService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.CoverLetter;

@RestController
@RequestMapping("/api/cover-letters")
@CrossOrigin
public class CoverLettersController {
	
	private CoverLetterService coverLetterService;
	private CandidateService candidateService;

	@Autowired
	public CoverLettersController(CoverLetterService coverLetterService, CandidateService candidateService) {
		super();
		this.coverLetterService = coverLetterService;
		this.candidateService = candidateService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestParam int candidateId, @RequestBody CoverLetter coverLetter ) {
		Candidate candidate = this.candidateService.findById(candidateId).getData();
		coverLetter.setCandidate(candidate);
		return this.coverLetterService.add(coverLetter);
	}
	
	@GetMapping("/getByCandidateId")
	public DataResult<CoverLetter> getByCandidateId(@RequestParam int candidateId){
		return this.coverLetterService.getByCandidateId(candidateId);
	}

}
