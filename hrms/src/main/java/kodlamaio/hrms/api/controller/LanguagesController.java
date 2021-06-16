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
import kodlamaio.hrms.business.abstracts.LanguageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.Language;

@RestController
@RequestMapping("/api/languages")
@CrossOrigin
public class LanguagesController {

	private LanguageService languageService;
	private CandidateService candidateService;

	@Autowired
	public LanguagesController(LanguageService languageService, CandidateService candidateService) {
		super();
		this.languageService = languageService;
		this.candidateService = candidateService;
	};
	
	@GetMapping("/getAllByCandidateId")
	public DataResult<List<Language>> getAllByCandidateId(@RequestParam int candidateId){
		return this.languageService.getAllByCandidateId(candidateId);
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestParam int candidateId, @Valid @RequestBody Language language){
		Candidate candidate = this.candidateService.findById(candidateId).getData();
		language.setCandidate(candidate);
		return ResponseEntity.ok(this.languageService.add(language));
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
