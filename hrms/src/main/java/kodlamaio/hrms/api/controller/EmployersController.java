package kodlamaio.hrms.api.controller;

import java.sql.Date;
import java.time.LocalDate;
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

import kodlamaio.hrms.business.abstracts.EmployerActivationBySystemPersonnelService;
import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.EmployerAcvtivationBySystemPersonnel;

@RestController
@RequestMapping("/api/employers")
@CrossOrigin
public class EmployersController {

	private EmployerService employerService;

	private EmployerActivationBySystemPersonnelService employerActivationBySystemPersonnelService;

	@Autowired
	public EmployersController(EmployerService employerService,
			EmployerActivationBySystemPersonnelService employerActivationBySystemPersonnelService) {
		super();
		this.employerService = employerService;
		this.employerActivationBySystemPersonnelService = employerActivationBySystemPersonnelService;

	}

	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody Employer employer) {
		return ResponseEntity.ok(this.employerService.add(employer));
	}

	@PostMapping("/setConfirmationStatus")
	public Result setConfirmationStatus(@RequestParam("employerId") int employerId,
			@RequestParam("confirmerSystemPersonnelId") int corfirmerSystemPersonnelId,
			@RequestParam("status") boolean status) {
		EmployerAcvtivationBySystemPersonnel employerAcvtivationBySystemPersonnel = new EmployerAcvtivationBySystemPersonnel();
		employerAcvtivationBySystemPersonnel.setEmployerId(employerId);
		employerAcvtivationBySystemPersonnel.setConfirmerSystemPersonnelId(corfirmerSystemPersonnelId);
		employerAcvtivationBySystemPersonnel.setConfirmedDate(Date.valueOf(LocalDate.now()));
		this.employerActivationBySystemPersonnelService.add(employerAcvtivationBySystemPersonnel);
		return this.employerService.setConfirmationStatus(employerId, status);
	}

	@GetMapping("/getAll")
	public DataResult<List<Employer>> getAll() {
		return this.employerService.getAll();
	}

	@GetMapping("/getAllAsc")
	public DataResult<List<Employer>> getAllAsc() {
		return this.employerService.getAllAsc();
	}

	@GetMapping("/getAllByPage")
	public DataResult<List<Employer>> getAll(int pageNo, int pageSize) {
		return this.employerService.getAll(pageNo, pageSize);
	}

	@GetMapping("/findById")
	public DataResult<Employer> findById(@RequestParam int employerId) {
		return this.employerService.findById(employerId);
	}

	@GetMapping("/findByEmail")
	public DataResult<Employer> findByEmail(@RequestParam String email) {
		return this.employerService.findByEmail(email);
	}

	@GetMapping("/getByIsConfirmed")
	public DataResult<List<Employer>> getByIsConfirmed(@RequestParam boolean isActive) {
		return this.employerService.getByIsConfirmed(isActive);
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
