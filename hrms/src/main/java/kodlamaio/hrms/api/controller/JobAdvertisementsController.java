package kodlamaio.hrms.api.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

@RestController
@RequestMapping("/api/job-advertisements")
public class JobAdvertisementsController {
	
	private JobAdvertisementService jobAdvertisementService;

	@Autowired
	public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<JobAdvertisement>> getAll(){
		return this.jobAdvertisementService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobAdvertisement jobAdvertisement) {
		return this.jobAdvertisementService.add(jobAdvertisement);
	}
	
	@PostMapping("/setActivityStatus")
	public Result setActivityStatus(@RequestParam int id, @RequestParam boolean status) {
		return this.jobAdvertisementService.setActivityStatus(id, status);
	}
	
	
	@GetMapping("/getByIsActive")
	public DataResult<List<JobAdvertisement>> getByIsActive(@RequestParam boolean isActive){
		return this.jobAdvertisementService.getByIsActive(isActive);
	}
	
	@GetMapping("/getByIsActivatedAndApplicationDeadline")
	public DataResult<List<JobAdvertisement>> getByIsActivatedAndApplicationDeadline(@RequestParam boolean isActivated, @RequestParam Date applicationDeadline){
		return this.jobAdvertisementService.getByIsActiveAndApplicationDeadline(isActivated, applicationDeadline);
	}
	
	@GetMapping("/getByIsActivatedAndEmployerId")
	public DataResult<List<JobAdvertisement>> getByIsActivatedAndEmployerId(@RequestParam boolean isActivated, @RequestParam int employerId){
		return this.jobAdvertisementService.getByIsActiveAndEmployerId(isActivated, employerId);
	}

}
