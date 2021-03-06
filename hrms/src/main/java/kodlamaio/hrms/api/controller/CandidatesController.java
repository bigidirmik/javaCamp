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
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.entities.concretes.Candidate;

@RestController
@RequestMapping("/api/candidates")
@CrossOrigin
public class CandidatesController {

	private CandidateService candidateService;

	@Autowired
	public CandidatesController(CandidateService candidateService) {
		super();
		this.candidateService = candidateService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody Candidate candidate) {
		return ResponseEntity.ok(this.candidateService.add(candidate));
	}

	@GetMapping("/getAll")
	public DataResult<List<Candidate>> getAll() {
		return this.candidateService.getAll();
	}

	@GetMapping("/getAllAsc")
	DataResult<List<Candidate>> getAllAsc() {
		return this.candidateService.getAllAsc();
	}

	@GetMapping("/getAllByPage")
	public DataResult<List<Candidate>> getAll(int pageNo, int pageSize) {
		return this.candidateService.getAll(pageNo, pageSize);
	}
	
	
	@GetMapping("/findById")
	public DataResult<Candidate> findById(@RequestParam int candidateId){
		return this.candidateService.findById(candidateId);
	}
	
	@GetMapping("/findByEmail")
	public DataResult<Candidate> findByEmail(@RequestParam String email){
		return this.candidateService.findByEmail(email);
	}
	
	@GetMapping("/findByNationalityId")
	public DataResult<Candidate> findByNationalityId(@RequestParam String nationalityId){
		return this.candidateService.findByNationalityId(nationalityId);
	}


	// hata f??rlatma

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions) {
		Map<String, String> validationErrors = new HashMap<String, String>();
		for (FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}

		ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors, "Do??rulama hatalar??");
		return errors;
	}

}
