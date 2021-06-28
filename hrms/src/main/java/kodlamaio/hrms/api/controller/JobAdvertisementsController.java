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

import kodlamaio.hrms.business.abstracts.CityService;
import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.abstracts.JobAdvertisementActivationBySystemPersonnelService;
import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.business.abstracts.JobTitleService;
import kodlamaio.hrms.business.abstracts.SystemPersonnelService;
import kodlamaio.hrms.business.abstracts.TypeOfJobService;
import kodlamaio.hrms.business.abstracts.WorkingTimeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.City;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.concretes.JobAdvertisementActivationBySystemPersonnel;
import kodlamaio.hrms.entities.concretes.JobTitle;
import kodlamaio.hrms.entities.concretes.TypeOfJob;
import kodlamaio.hrms.entities.concretes.WorkingTime;

@RestController
@RequestMapping("/api/job-advertisements")
@CrossOrigin
public class JobAdvertisementsController {

	private JobAdvertisementService jobAdvertisementService;

	private EmployerService employerService;
	private JobTitleService jobTitleService;
	private CityService cityService;
	private TypeOfJobService typeOfJobService;
	private WorkingTimeService workingTimeService;

	private JobAdvertisementActivationBySystemPersonnelService jobAdvertisementActivationBySystemPersonnelService;

	@Autowired
	public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService, EmployerService employerService,
			JobTitleService jobTitleService, CityService cityService, TypeOfJobService typeOfJobService,
			WorkingTimeService workingTimeService, SystemPersonnelService systemPersonnelService,
			JobAdvertisementActivationBySystemPersonnelService jobAdvertisementActivationBySystemPersonnelService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
		this.employerService = employerService;
		this.jobTitleService = jobTitleService;
		this.cityService = cityService;
		this.typeOfJobService = typeOfJobService;
		this.workingTimeService = workingTimeService;
		this.jobAdvertisementActivationBySystemPersonnelService = jobAdvertisementActivationBySystemPersonnelService;
	}

	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestParam int employerId, @RequestParam int jobTitleId, @RequestParam int cityId,
			@RequestParam int typeOfJobId, @RequestParam int workingTimeId,
			@Valid @RequestBody JobAdvertisement jobAdvertisement) {
		Employer employer = this.employerService.findById(employerId).getData();
		JobTitle jobTitle = this.jobTitleService.findById(jobTitleId).getData();
		City city = this.cityService.findById(cityId).getData();
		TypeOfJob typeOfJob = this.typeOfJobService.findById(typeOfJobId).getData();
		WorkingTime workingTime = this.workingTimeService.findById(workingTimeId).getData();
		jobAdvertisement.setEmployer(employer);
		jobAdvertisement.setJobTitle(jobTitle);
		jobAdvertisement.setCity(city);
		jobAdvertisement.setTypeOfJob(typeOfJob);
		jobAdvertisement.setWorkingTime(workingTime);
		return ResponseEntity.ok(this.jobAdvertisementService.add(jobAdvertisement));
	}

	@PostMapping("/setActivityStatus")
	public Result setActivityStatus(@RequestParam("jobAdvertisementId") int jobAdvertisementId,
			@RequestParam("status") boolean status) {
		return this.jobAdvertisementService.setActivityStatus(jobAdvertisementId, status);
	}

	@PostMapping("/setConfirmationStatus")
	public Result setConfirmationStatus(@RequestParam("jobAdvertisementId") int jobAdvertisementId,
			@RequestParam("confirmerSystemPersonnelId") int confirmerSystemPersonnelId,
			@RequestParam("status") boolean status) {
		JobAdvertisementActivationBySystemPersonnel jobAdvertisementActivationBySystemPersonnel = new JobAdvertisementActivationBySystemPersonnel();
		jobAdvertisementActivationBySystemPersonnel.setJobAdvertisementId(jobAdvertisementId);
		jobAdvertisementActivationBySystemPersonnel.setConfirmerSystemPersonnelId(confirmerSystemPersonnelId);
		jobAdvertisementActivationBySystemPersonnel.setConfirmedDate(Date.valueOf(LocalDate.now()));
		this.jobAdvertisementActivationBySystemPersonnelService.add(jobAdvertisementActivationBySystemPersonnel);
		return this.jobAdvertisementService.setConfirmationStatus(jobAdvertisementId, status);
	}

	
	@GetMapping("/findById")
	public DataResult<JobAdvertisement> findById(@RequestParam int id) {
		return this.jobAdvertisementService.findById(id);
	}
	
	@GetMapping("/getAll")
	public DataResult<List<JobAdvertisement>> getAll() {
		return this.jobAdvertisementService.getAll();
	}

	@GetMapping("/getAllAsc")
	public DataResult<List<JobAdvertisement>> getAllAsc() {
		return this.jobAdvertisementService.getAllAsc();
	}

	@GetMapping("/getAllByPage")
	public DataResult<List<JobAdvertisement>> getAll(int pageNo, int pageSize) {
		return this.jobAdvertisementService.getAll(pageNo, pageSize);
	}

	@GetMapping("/getByIsActive")
	public DataResult<List<JobAdvertisement>> getByIsActive(@RequestParam boolean isActive) {
		return this.jobAdvertisementService.getByIsActive(isActive);
	}

	@GetMapping("/getByIsActiveAndApplicationDeadline")
	public DataResult<List<JobAdvertisement>> getByIsActiveAndApplicationDeadline(
			@RequestParam("isActive") boolean isActive, @RequestParam("applicationDeadline") Date applicationDeadline) {
		return this.jobAdvertisementService.getByIsActiveAndApplicationDeadline(isActive, applicationDeadline);
	}

	@GetMapping("/getByIsActiveAndEmployerId")
	public DataResult<List<JobAdvertisement>> getByIsActiveAndEmployerId(@RequestParam("isActive") boolean isActive,
			@RequestParam("employerId") int employerId) {
		return this.jobAdvertisementService.getByIsActiveAndEmployerId(isActive, employerId);
	}

	@GetMapping("/getByQueryActiveAndAppDeadlineAsc")
	public DataResult<List<JobAdvertisement>> getByQueryActiveAndAppDeadlineAsc(
			@RequestParam("isActive") boolean isActive, @RequestParam("applicationDeadline") Date applicationDeadline) {
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
