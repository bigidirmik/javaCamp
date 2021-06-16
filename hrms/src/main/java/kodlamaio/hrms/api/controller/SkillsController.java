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
import kodlamaio.hrms.business.abstracts.SkillService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.Skill;

@RestController
@RequestMapping("/api/skills")
@CrossOrigin
public class SkillsController {

	private SkillService skillService;
	private CandidateService candidateService;

	@Autowired
	public SkillsController(SkillService skillService, CandidateService candidateService) {
		super();
		this.skillService = skillService;
		this.candidateService = candidateService;
	};
	
	@PostMapping("/add")
	public Result add(int candidateId, @RequestBody Skill skill) {
		Candidate candidate = this.candidateService.findById(candidateId).getData();
		skill.setCandidate(candidate);
		return this.skillService.add(skill);
	}
	
	@GetMapping("/getAllByCandidateId")
	public DataResult<List<Skill>> getAllByCandidateId(@RequestParam int candidateId){
		return this.skillService.getAllByCandidateId(candidateId);
	}
		
	
}
