package kodlamaio.hrms.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.EmployerActivationBySystemPersonnelService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.EmployerAcvtivationBySystemPersonnel;

@RestController
@RequestMapping("/api/employer-activations-by-system-personnel")
public class EmployerActivationsBySystemPersonnelController {
	
	private EmployerActivationBySystemPersonnelService employerActivationBySystemPersonnelService;

	@Autowired
	public EmployerActivationsBySystemPersonnelController(
			EmployerActivationBySystemPersonnelService employerActivationBySystemPersonnelService) {
		super();
		this.employerActivationBySystemPersonnelService = employerActivationBySystemPersonnelService;
	}
	
	@GetMapping("/getByEmployerId")
	public DataResult<EmployerAcvtivationBySystemPersonnel> getByEmployerId(@RequestParam int employerId){
		return this.employerActivationBySystemPersonnelService.getByEmployerId(employerId);
	}
	
	@GetMapping("/getByConfirmerSystemPersonnelId")
	public DataResult<List<EmployerAcvtivationBySystemPersonnel>> getByConfirmerSystemPersonnelId(@RequestParam int confirmerSystemPersonnelId){
		return this.employerActivationBySystemPersonnelService.getByConfirmerSystemPersonnelId(confirmerSystemPersonnelId);
	}

}
