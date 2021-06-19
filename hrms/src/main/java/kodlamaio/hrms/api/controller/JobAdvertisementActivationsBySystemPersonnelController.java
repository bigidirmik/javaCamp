package kodlamaio.hrms.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobAdvertisementActivationBySystemPersonnelService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.JobAdvertisementActivationBySystemPersonnel;

@RestController
@RequestMapping("/api/job-advertisement-activations-by-system-personnel")
public class JobAdvertisementActivationsBySystemPersonnelController {

	private JobAdvertisementActivationBySystemPersonnelService jobAdvertisementActivationBySystemPersonnelService;

	@Autowired
	public JobAdvertisementActivationsBySystemPersonnelController(
			JobAdvertisementActivationBySystemPersonnelService jobAdvertisementActivationBySystemPersonnelService) {
		super();
		this.jobAdvertisementActivationBySystemPersonnelService = jobAdvertisementActivationBySystemPersonnelService;
	}

	@GetMapping("/getByJobAdvertisementId")
	public DataResult<JobAdvertisementActivationBySystemPersonnel> getByJobAdvertisementId(
			@RequestParam int jobAdvertisementId) {
		return this.jobAdvertisementActivationBySystemPersonnelService.getByJobAdvertisementId(jobAdvertisementId);
	}

	@GetMapping("/getByConfirmerSystemPersonnelId")
	public DataResult<List<JobAdvertisementActivationBySystemPersonnel>> getByConfirmerSystemPersonnelId(
			@RequestParam int confirmerSystemPersonnelId) {
		return this.jobAdvertisementActivationBySystemPersonnelService
				.getByConfirmerSystemPersonnelId(confirmerSystemPersonnelId);
	}

}
