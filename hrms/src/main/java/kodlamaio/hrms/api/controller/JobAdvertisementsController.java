package kodlamaio.hrms.api.controller;

import java.sql.Date;
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

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

@RestController
@RequestMapping("/api/job-advertisements")
@CrossOrigin
public class JobAdvertisementsController {
	
	private JobAdvertisementService jobAdvertisementService;

	@Autowired
	public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	}
	
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody JobAdvertisement jobAdvertisement) {
		return ResponseEntity.ok(this.jobAdvertisementService.add(jobAdvertisement));
	}
	
	
	@GetMapping("/getAll")
	public DataResult<List<JobAdvertisement>> getAll(){
		return this.jobAdvertisementService.getAll();
	}
	
	@GetMapping("/getAllAsc")
	public DataResult<List<JobAdvertisement>> getAllAsc(){
		return this.jobAdvertisementService.getAllAsc();
	}
	
	@GetMapping("/getAllByPage")
	public DataResult<List<JobAdvertisement>> getAll(int pageNo, int pageSize){
		return this.jobAdvertisementService.getAll(pageNo, pageSize);
	}
	
	@PostMapping("/setActivityStatus")
	public Result setActivityStatus(@RequestParam("id") int id, @RequestParam("status") boolean status) {
		return this.jobAdvertisementService.setActivityStatus(id, status);
	}
	
	
	@GetMapping("/getByIsActive")
	public DataResult<List<JobAdvertisement>> getByIsActive(@RequestParam boolean isActive){
		return this.jobAdvertisementService.getByIsActive(isActive);
	}
	
	@GetMapping("/getByIsActiveAndApplicationDeadline")
	public DataResult<List<JobAdvertisement>> getByIsActiveAndApplicationDeadline(@RequestParam("isActive") boolean isActive, @RequestParam("applicationDeadline") Date applicationDeadline){
		return this.jobAdvertisementService.getByIsActiveAndApplicationDeadline(isActive, applicationDeadline);
	}
	
	@GetMapping("/getByIsActiveAndEmployerId")
	public DataResult<List<JobAdvertisement>> getByIsActiveAndEmployerId(@RequestParam("isActive") boolean isActive, @RequestParam("employerId") int employerId){
		return this.jobAdvertisementService.getByIsActiveAndEmployerId(isActive, employerId);
	}
	
	
	@GetMapping("/getByQueryActiveAndAppDeadlineAsc")
	public DataResult<List<JobAdvertisement>> getByQueryActiveAndAppDeadlineAsc(@RequestParam("isActive") boolean isActive, @RequestParam("applicationDeadline") Date applicationDeadline){
		return this.jobAdvertisementService.getByQueryActiveAndAppDeadlineAsc(isActive, applicationDeadline);
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
