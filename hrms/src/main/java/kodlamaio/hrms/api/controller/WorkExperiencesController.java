package kodlamaio.hrms.api.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.abstracts.WorkExperienceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.WorkExperience;

@RestController
@RequestMapping("/api/work-experiences")
@CrossOrigin
public class WorkExperiencesController {
	
	private WorkExperienceService workExperienceService;
	private CandidateService candidateService;

	@Autowired
	public WorkExperiencesController(WorkExperienceService workExperienceService, CandidateService candidateService) {
		super();
		this.workExperienceService = workExperienceService;
		this.candidateService = candidateService;
	}
	
	@GetMapping("/getAllByCandidateIdOrderByEndDateDesc")
	public DataResult<List<WorkExperience>> getAllByCandidateIdOrderByEndDateDesc(@RequestParam int candidateId){
		return this.workExperienceService.getAllByCandidateIdOrderByEndDateDesc(candidateId);
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestParam int candidateId, @Valid @RequestBody WorkExperience workExperience) {
		Candidate candidate = this.candidateService.findById(candidateId).getData();
		workExperience.setCandidate(candidate);
		return ResponseEntity.ok(this.workExperienceService.add(workExperience));
	}
	
	
	// hata fırlatma

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions) {
		Map<String, String> validationErrors = new HashMap<String, String>();
		for (FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}

		ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors, "Doğrulama hataları");
		return errors;
	}

}
